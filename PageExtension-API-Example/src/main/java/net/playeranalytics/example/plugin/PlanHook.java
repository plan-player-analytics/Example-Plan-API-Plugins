package net.playeranalytics.example.plugin;

import com.djrapitops.plan.capability.CapabilityService;
import com.djrapitops.plan.delivery.web.ResourceService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.function.Function;

public class PlanHook {

    public void hookIntoPlan(Function<String, InputStream> readResourceMethod) {
        CapabilityService capabilities = CapabilityService.getInstance();

        String[] requiredCapabilities = new String[]{
                "PAGE_EXTENSION_RESOLVERS",
                "PAGE_EXTENSION_RESOLVERS_LIST",
                "PAGE_EXTENSION_RESOURCES",
                "PAGE_EXTENSION_RESOURCES_REGISTER_DIRECT_CUSTOMIZATION"
        };
        for (String requiredCapability : requiredCapabilities) {
            if (!capabilities.hasCapability(requiredCapability)) {
                System.out.println("Plan doesn't have capability '" + requiredCapability + "', you need to update Plan!");
                return;
            }
        }

        try (InputStream in = readResourceMethod.apply("example.js")) {
            ResourceService.getInstance().addJavascriptToResource(
                    "Example-PageExtensionApiPlugin",
                    "index.html",
                    ResourceService.Position.PRE_MAIN_SCRIPT,
                    "example.js",
                    new String(in.readAllBytes(), StandardCharsets.UTF_8)
            );
        } catch (IOException e) {
            // Log this properly
            e.printStackTrace();
        }
    }

}
