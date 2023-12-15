window.addEventListener("load", solve);

function solve() {
    const addButton = document.getElementById("add-btn");
    const playerNameInputEl = document.getElementById("player");
    const scoreInputEl = document.getElementById("score");
    const roundInputEl = document.getElementById("round");
    const tempDartUlEl = document.getElementById("sure-list");
    const scoreboardUl = document.getElementById("scoreboard-list");
    const clearBtn = document.querySelector('.btn.clear');

    function clearInputFields(){
        playerNameInputEl.value = "";
        scoreInputEl.value = "";
        roundInputEl.value = "";
    }

    addButton.addEventListener("click", addHandler);
    clearBtn.addEventListener("click", () => {location.reload()})

    function addHandler(e){
        if(playerNameInputEl.value == ''
        || scoreInputEl.value == ''
        || roundInputEl.value == ''){
            return;
        }

        let infoLiToAdd = document.createElement("li");
        infoLiToAdd.className = "dart-item";

        let articleEl = document.createElement("article");

        let nameP = document.createElement("p");
        nameP.textContent = playerNameInputEl.value;

        let scoreP = document.createElement("p");
        scoreP.textContent = `Score: ${scoreInputEl.value}`;

        let roundP = document.createElement("p");
        roundP.textContent = `Round: ${roundInputEl.value}`;

        let editBtn = document.createElement("button");
        editBtn.className = "btn edit";
        editBtn.textContent = "edit";
        editBtn.addEventListener("click", () => {
            playerNameInputEl.value = nameP.textContent;
            scoreInputEl.value = Number(scoreP.textContent.substring(7));
            roundInputEl.value = Number(roundP.textContent.substring(7));

            infoLiToAdd.remove();
            addButton.disabled = false;
        });

        let okBtn = document.createElement("button");
        okBtn.className = "btn ok";
        okBtn.textContent = "ok";
        okBtn.addEventListener("click", () => {
            const liToTransfer = infoLiToAdd.cloneNode(true);
            infoLiToAdd.remove();

            liToTransfer.childNodes[2].remove();
            liToTransfer.childNodes[1].remove();

            scoreboardUl.appendChild(liToTransfer);
            addButton.disabled = false;
        })

        articleEl.appendChild(nameP);
        articleEl.appendChild(scoreP);
        articleEl.appendChild(roundP);

        infoLiToAdd.appendChild(articleEl);
        infoLiToAdd.appendChild(editBtn);
        infoLiToAdd.appendChild(okBtn);

        tempDartUlEl.appendChild(infoLiToAdd);

        addButton.disabled = true;
        clearInputFields();
    }
}
  