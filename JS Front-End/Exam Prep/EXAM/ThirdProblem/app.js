function onLoad(){
    const BASE_URL = "http://localhost:3030/jsonstore/tasks";
    const mealsListDiv = document.getElementById("list");
    const loadMealsBtn = document.getElementById("load-meals");
    const addMealBtn = document.getElementById("add-meal");
    const editMealBtn = document.getElementById("edit-meal");
    const foodInputEl = document.getElementById("food");
    const timeInputEl = document.getElementById("time");
    const caloriesInputEl = document.getElementById("calories");
    let idCounter = 1;

    loadMealsBtn.addEventListener("click", loadMealsHandler);
    addMealBtn.addEventListener("click", addMealHandler);
    editMealBtn.addEventListener("click", editMealHandler);

    function loadMealsHandler(e){
        mealsListDiv.innerHTML = "";

        fetch(BASE_URL, {method: "GET"})
        .then((response) => response.json())
        .then((meals) => Object.values(meals).forEach(
            ({food, calories, time, _id}) => {
                let containerDiv = document.createElement("div");
                containerDiv.className = "meal";
                containerDiv.id = _id;

                let foodH2 = document.createElement("h2");
                foodH2.textContent = food;

                let timeH3 = document.createElement("h3");
                timeH3.textContent = time;

                let caloriesH3 = document.createElement("h3");
                caloriesH3.textContent = calories;

                let btnsContainerDiv = document.createElement("div");
                btnsContainerDiv.className = "meal-buttons";

                let changeBtn = document.createElement("button");
                changeBtn.className = "change-meal";
                changeBtn.textContent = "Change";
                changeBtn.addEventListener("click", (e) => {

                    e.target.parentElement.parentElement.remove();

                    foodInputEl.value = food;
                    caloriesInputEl.value = calories;
                    timeInputEl.value = time;

                    foodInputEl.parentElement.id = _id;

                    editMealBtn.disabled = false;
                    addMealBtn.disabled = true;
                });

                let deleteBtn = document.createElement("button");
                deleteBtn.className = "delete-meal";
                deleteBtn.textContent = "Delete";
                deleteBtn.addEventListener("click", () => {
                    fetch(BASE_URL + '/' + _id, {
                        method: "DELETE"
                    });

                    loadMealsHandler();
                });

                btnsContainerDiv.appendChild(changeBtn);
                btnsContainerDiv.appendChild(deleteBtn);

                containerDiv.appendChild(foodH2);
                containerDiv.appendChild(timeH3);
                containerDiv.appendChild(caloriesH3);
                containerDiv.appendChild(btnsContainerDiv);

                mealsListDiv.appendChild(containerDiv);
            }
        ));
    }

    function addMealHandler(){
        idCounter++;
        fetch(BASE_URL, {
            method: "POST",
            body: JSON.stringify({
                food: foodInputEl.value,
                calories: caloriesInputEl.value,
                time: timeInputEl.value,
                _id: idCounter
            })
        });

        loadMealsHandler();
        clearInputFields();
    }

    function editMealHandler(){
        let mealId = document.getElementsByTagName("form")[0].id;
        fetch(BASE_URL + "/" + mealId, {
            method: "PUT",
            body: JSON.stringify({
                food: foodInputEl.value,
                calories: caloriesInputEl.value,
                time: timeInputEl.value,
                _id: mealId
            })
        });

        addMealBtn.disabled = false;
        editMealBtn.disabled = true;
        clearInputFields();
        loadMealsHandler();
    }

    function clearInputFields(){
        foodInputEl.value = "";
        timeInputEl.value = "";
        caloriesInputEl.value = "";
    }
}

window.addEventListener("load", onLoad);