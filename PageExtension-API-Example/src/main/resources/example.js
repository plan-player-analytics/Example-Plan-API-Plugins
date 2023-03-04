// This script adds a "Hello world" text at the top of "Server as Numbers" card body as an example
// Open the /server/{servername} page to see the script in action.

const render = async (context) => {
    /* Any code that needs to run before the element is added to DOM */

    // Context is logged to console when the element is rendered so that you can see what it contains
    // The contents of the context may change from time to time, so it's recommended to code defensively.
    // So check that any variable exists in an if-block before using it.
    console.log(context)

    return '<div class="card-body"><p>Hello world</p></div>';
}

// Alternative that uses DOM to create elements
// const render = async () => {
//     const para = document.createElement("p");
//     para.innerText = "Hello world";
//     return para;
// }

const unmount = async () => {
    /* Any code that needs to run before the element is removed from DOM */
};

// 'beforeElement' or 'afterElement' determines where elements are added
// 'card-body-server-as-numbers' is the ID of the element we're adding to.
// Look for elements with class "extendable" in the Browser Dev Tools > Inspector to find elements you can add items to
pageExtensionApi.registerElement('beforeElement', 'card-body-server-as-numbers', render, unmount);

// Here is another example that adds a new card on the page rather than adding content to existing cards
// pageExtensionApi.registerElement('afterElement', 'row-server-overview-0', () => '<div class="row"><div class="col-md-12"><div class="card"><div class="card-body"><p>Hello World</p></div></div></div></div>', () => {});