function addItem() {
    let textToAdd = document.getElementById("newItemText").value;
    let elToAdd = document.createElement("li");
    elToAdd.textContent = textToAdd;
    let parentElement = document.getElementById("items");
    parentElement.appendChild(elToAdd);
}