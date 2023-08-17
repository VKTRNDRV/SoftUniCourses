function deleteByEmail() {
    let emailToDelete = document.getElementsByName("email")[0].value;
    let allItems = Array.from(document.getElementsByTagName("tbody")[0].children);
    let isDeleted = false;
    for(let trElement of allItems){
        let email = trElement.children[1].textContent;
        if(email == emailToDelete){
            trElement.remove();
            isDeleted = true;
            break;
        }
    }

    let resultDiv = document.getElementById("result");

    if(isDeleted === true){
        resultDiv.textContent = "Deleted.";
    }else{
        resultDiv.textContent = "Not found.";
    }
}