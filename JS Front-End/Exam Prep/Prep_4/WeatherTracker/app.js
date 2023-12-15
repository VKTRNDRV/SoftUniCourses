function onLoad(){
    const BASE_URL = "http://localhost:3030/jsonstore/tasks";
    const recordsListDiv = document.getElementById("list");
    const loadRecordsBtn = document.getElementById("load-history");
    const editRecordBtn = document.getElementById("edit-weather");
    const addRecordBtn = document.getElementById("add-weather");
    const locationInputEl = document.getElementById("location");
    const tempInputEl = document.getElementById("temperature");
    const dateInputEl = document.getElementById("date");
    let idCounter = 1;

    loadRecordsBtn.addEventListener("click", loadRecordsHandler);
    addRecordBtn.addEventListener("click", addRecordHandler);
    editRecordBtn.addEventListener("click", editRecordHandler);


    function loadRecordsHandler(){
        recordsListDiv.innerHTML = "";

        fetch(BASE_URL, {method: "GET"})
        .then((response) => response.json())
        .then((items) => Object.values(items).forEach(
            ({location, temperature, date, _id}) => {
                let containerDiv = document.createElement("div");
                containerDiv.className = "container";
                containerDiv.id = _id;

                let locationH2 = document.createElement("h2");
                locationH2.textContent = location;

                let dateH3 = document.createElement("h3");
                dateH3.textContent = date;

                let tempH3 = document.createElement("h3");
                tempH3.id = "celsius";
                tempH3.textContent = temperature;

                let btnsContainerDiv = document.createElement("div");
                btnsContainerDiv.className = "buttons-container";

                let changeBtn = document.createElement("button");
                changeBtn.className = "change-btn";
                changeBtn.textContent = "Change";
                changeBtn.addEventListener("click", (e) => {

                    e.target.parentElement.parentElement.remove();

                    locationInputEl.value = location;
                    tempInputEl.value = temperature;
                    dateInputEl.value = date;

                    locationInputEl.parentElement.id = _id;

                    editRecordBtn.disabled = false;
                    addRecordBtn.disabled = true;
                });

                let deleteBtn = document.createElement("button");
                deleteBtn.className = "delete-btn";
                deleteBtn.textContent = "Delete";
                deleteBtn.addEventListener("click", () => {
                    fetch(BASE_URL + '/' + _id, {
                        method: "DELETE"
                    });

                    loadRecordsHandler();
                });

                btnsContainerDiv.appendChild(changeBtn);
                btnsContainerDiv.appendChild(deleteBtn);

                containerDiv.appendChild(locationH2);
                containerDiv.appendChild(dateH3);
                containerDiv.appendChild(tempH3);
                containerDiv.appendChild(btnsContainerDiv);

                recordsListDiv.appendChild(containerDiv);
            }
        ));
    }

    function addRecordHandler(){
        idCounter++;
        fetch(BASE_URL, {
            method: "POST",
            body: JSON.stringify({
                location: locationInputEl.value,
                temperature: tempInputEl.value,
                date: dateInputEl.value,
                _id: idCounter
            })
        });

        loadRecordsHandler();
        clearInputFields();
    }

    function editRecordHandler(){
        let recordId = document.getElementsByTagName("form")[0].id;
        fetch(BASE_URL + "/" + recordId, {
            method: "PUT",
            body: JSON.stringify({
                location: locationInputEl.value,
                temperature: tempInputEl.value,
                date: dateInputEl.value,
                _id: recordId
            })
        });

        addRecordBtn.disabled = false;
        editRecordBtn.disabled = true;
        clearInputFields();
        loadRecordsHandler();
    }

    function clearInputFields(){
        locationInputEl.value = "";
        tempInputEl.value = "";
        dateInputEl.value = "";
    }
}

window.addEventListener("load", onLoad);