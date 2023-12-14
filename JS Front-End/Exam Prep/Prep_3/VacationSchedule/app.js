const BASE_URL = "http://localhost:3030/jsonstore/tasks";
const loadVacationsBtn = document.getElementById("load-vacations");
const addVacationBtn = document.getElementById("add-vacation");
const editVacationBtn = document.getElementById("edit-vacation");
const vacationsListEl = document.getElementById("list");
const nameInputEl = document.getElementById("name");
const numDaysEl = document.getElementById("num-days");
const fromDateEl = document.getElementById("from-date");
let idCounter = 1;

function solve(){
    loadVacationsBtn.addEventListener("click", loadVacationsHandler);
    addVacationBtn.addEventListener("click", addVacationHandler);
    editVacationBtn.addEventListener("click", editVacationHandler);

    function clearInputFields(){
        nameInputEl.value = '';
        numDaysEl.value = '';
        fromDateEl.value = '';
        nameInputEl.parentElement.id = '';
    }

    function loadVacationsHandler(e){
        if(e){
            e.preventDefault();
        }

        vacationsListEl.innerHTML = "";

        fetch(BASE_URL)
        .then((response) => response.json())
        .then((list) => { Object.values(list).forEach(
            ({name, days, date, _id}) => {
            let containerDiv = document.createElement("div");
            containerDiv.className = "container";

            let nameH2 = document.createElement("h2");
            nameH2.textContent = name;

            let dateH3 = document.createElement("h3");
            dateH3.textContent = date;

            let daysH3 = document.createElement("h3");
            daysH3.textContent = days;

            let changeBtn = document.createElement("button");
            changeBtn.className = "change-btn";
            changeBtn.textContent = "Change";
            changeBtn.addEventListener("click", (e) => {
                editVacationBtn.disabled = false;
                addVacationBtn.disabled = true;

                nameInputEl.value = name;
                numDaysEl.value = Number(days);
                fromDateEl.value = date;

                nameInputEl.parentElement.id = _id;

                containerDiv.remove();
            });

            let doneBtn = document.createElement("button");
            doneBtn.className = "done-btn";
            doneBtn.textContent = "Done";
            doneBtn.addEventListener("click", () => {
                fetch(`${BASE_URL}/${_id}`, {method: 'DELETE'})
                .then(() => loadVacationsHandler())
            });

            containerDiv.appendChild(nameH2);
            containerDiv.appendChild(dateH3);
            containerDiv.appendChild(daysH3);
            containerDiv.appendChild(changeBtn);
            containerDiv.appendChild(doneBtn);

            vacationsListEl.appendChild(containerDiv);
        })})
        .catch((err) => console.log(err));
    }

    function addVacationHandler(e){
        if(e){
            e.preventDefault();
        }

        idCounter++;
        fetch(BASE_URL, {method: 'POST', body: JSON.stringify({
            name: nameInputEl.value,
            days: numDaysEl.value,
            date: fromDateEl.value,
            _id: idCounter
        })})
        .then(() => {
            clearInputFields();
        })
        .then(() => loadVacationsHandler());
    }

    function editVacationHandler(e){
        let vacationId = nameInputEl.parentElement.id;
        fetch(`${BASE_URL}/${vacationId}`, {
            method: "PATCH",
            body: JSON.stringify({
                name: nameInputEl.value,
                days: numDaysEl.value,
                date: fromDateEl.value,
                _id: vacationId

            })
        }).then(
            () => {
                editVacationBtn.disabled = true;
                addVacationBtn.disabled = false;
                clearInputFields();
                loadVacationsHandler();
            }
        )
    }
}

solve();