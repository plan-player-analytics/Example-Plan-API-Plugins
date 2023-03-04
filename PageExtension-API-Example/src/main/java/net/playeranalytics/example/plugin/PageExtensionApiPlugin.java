package net.playeranalytics.example.plugin;

import org.bukkit.plugin.java.JavaPlugin;

// You can use any platform Plan supports, this example uses spigot as example.
public class PageExtensionApiPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        try {
            new PlanHook().hookIntoPlan(this::getResource);
        } catch (NoClassDefFoundError planIsNotInstalled) {
            // Plan is not installed
        }
    }
}
