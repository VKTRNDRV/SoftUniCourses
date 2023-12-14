window.addEventListener("load", solve);

function solve() {
    let studentNameEl = document.getElementById("student");
    let universityEl = document.getElementById("university");
    let scoreEl = document.getElementById("score");
    let nextBtn = document.getElementById("next-btn");
    let previewList = document.getElementById("preview-list");
    let candidatesListEl = document.getElementById("candidates-list");

    nextBtn.addEventListener("click", nextHandler);

    function nextHandler(e){
        if(studentNameEl.value === ""
        || universityEl.value === ""
        || scoreEl.value === ""){
            return;
        }
        
        let liEl = document.createElement("li");
        liEl.className = "application";

        let article = document.createElement("article");

        let nameH4 = document.createElement("h4");
        nameH4.textContent = studentNameEl.value;

        let uniP = document.createElement("p");
        uniP.textContent = `University: ${universityEl.value}`;

        let scoreP = document.createElement("p");
        scoreP.textContent = `Score: ${scoreEl.value}`;

        let editBtn = document.createElement("button");
        editBtn.className = "action-btn edit";
        editBtn.textContent = "edit";
        editBtn.addEventListener("click", () => {
            studentNameEl.value = nameH4.textContent;
            universityEl.value = uniP.textContent.substring(12)
            scoreEl.value = Number(scoreP.textContent.substring(7));
            liEl.remove();
            nextBtn.disabled = false;
        })

        let applyBtn = document.createElement("button");
        applyBtn.className = "action-btn apply";
        applyBtn.textContent = "apply";
        applyBtn.addEventListener("click", () =>{
            let clonedLi = liEl.cloneNode(true);
            clonedLi.childNodes[1].remove();
            clonedLi.childNodes[1].remove();
            candidatesListEl.appendChild(clonedLi);
            liEl.remove();

            nextBtn.disabled = false;
        })

        article.appendChild(nameH4);
        article.appendChild(uniP);
        article.appendChild(scoreP);

        liEl.appendChild(article);
        liEl.appendChild(editBtn);
        liEl.appendChild(applyBtn)

        previewList.appendChild(liEl);

        studentNameEl.value = "";
        universityEl.value = "";
        scoreEl.value = "";
        nextBtn.disabled = true;
    }
}
  