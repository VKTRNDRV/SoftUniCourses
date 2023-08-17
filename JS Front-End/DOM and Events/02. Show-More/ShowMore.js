function showText() {
    let element = document.getElementById("more");
    let parentElement = element.parentElement;
    element.remove();
    parentElement.textContent = 'Welcome to the "Show More Text Example". Welcome to JavaScript and DOM';
}