function addItem() {
    let itemName = document.getElementById("newItemText");
    let itemValue = document.getElementById("newItemValue");
    let menu = document.getElementById("menu");

    let optionEl = document.createElement("option");
    optionEl.textContent = `${itemName.value} - ${itemValue.value}`;

    menu.appendChild(optionEl);
    itemName.value = "";
    itemValue.value = "";
}