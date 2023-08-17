function addItem() {
    let textToAdd = document.getElementById("newItemText").value;
    let elToAdd = document.createElement("li");
    elToAdd.textContent = textToAdd;
    let deleteAnchor = document.createElement("a");
    deleteAnchor.appendChild(document.createTextNode("[Delete]"));
    deleteAnchor.href = "#";
    deleteAnchor.addEventListener("click", delItem);
    elToAdd.appendChild(deleteAnchor);

    let parentElement = document.getElementById("items");
    parentElement.appendChild(elToAdd);

    function delItem(){
        elToAdd.remove();
    }
}