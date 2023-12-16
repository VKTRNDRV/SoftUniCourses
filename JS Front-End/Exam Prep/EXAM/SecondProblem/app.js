window.addEventListener("load", solve);

function solve(){
    const expenseTypeInputEl = document.getElementById("expense");
    const amountInputEl = document.getElementById("amount");
    const dateInputEl = document.getElementById("date");
    const addBtn = document.getElementById("add-btn");
    const previewUl = document.getElementById("preview-list");
    const expensesUl = document.getElementById("expenses-list");
    const deleteReloadBtn = document.querySelector(".btn.delete");

    function clearInputFields(){
        expenseTypeInputEl.value = "";
        amountInputEl.value = "";
        dateInputEl.value = "";
    }

    addBtn.addEventListener("click", addEventHandler);
    deleteReloadBtn.addEventListener("click", () => {location.reload()});

    function addEventHandler(e){
        if(expenseTypeInputEl.value == "" 
        || amountInputEl.value == "" 
        || dateInputEl.value == ""){
            return;
        }

        let previewLi = document.createElement("li");
        previewLi.className = "expense-item";

        let previewArticle = document.createElement("article");

        let expenseTypeP = document.createElement("p");
        expenseTypeP.textContent = `Type: ${expenseTypeInputEl.value}`;

        let amountP = document.createElement("p");
        amountP.textContent = `Amount: ${amountInputEl.value}$`;

        let dateP = document.createElement("p");
        dateP.textContent = `Date: ${dateInputEl.value}`;

        let buttonsDiv = document.createElement("div");
        buttonsDiv.className = "buttons";

        let editBtn = document.createElement("button");
        editBtn.className = "btn edit";
        editBtn.addEventListener("click", () => {
            expenseTypeInputEl.value = expenseTypeP.textContent.substring(6);
            amountInputEl.value = amountP.textContent
            .substring(8, amountP.textContent.length - 1);
            dateInputEl.value = dateP.textContent.substring(6);

            previewLi.remove();
            addBtn.disabled = false;
        })
        editBtn.textContent = "edit";

        let okBtn = document.createElement("button");
        okBtn.className = "btn ok";
        okBtn.addEventListener("click", () => {
            let clonedLi = previewLi.cloneNode(true);
            clonedLi.childNodes[1].remove();
            previewLi.remove();

            expensesUl.appendChild(clonedLi);
            addBtn.disabled = false;
        });
        okBtn.textContent = "ok";

        previewArticle.appendChild(expenseTypeP);
        previewArticle.appendChild(amountP);
        previewArticle.appendChild(dateP);

        buttonsDiv.appendChild(editBtn);
        buttonsDiv.appendChild(okBtn);

        previewLi.appendChild(previewArticle);
        previewLi.appendChild(buttonsDiv);

        previewUl.appendChild(previewLi);

        addBtn.disabled = true;
        clearInputFields();
    }
}