function foodForPets(input){

    let totalDays = Number(input[0]);
    let totalFood = Number(input[1]);

    let totalEatenFood = 0;
    let totalEatenFoodByDog = 0;
    let totalEatenFoodByCat = 0;
    let totalEatenBiscuits = 0;
    
    input.shift();
    input.shift();

    let i = 0;
    let currentDay = 1;
    while(i < input.length){

        totalEatenFood += Number(input[i]);
        totalEatenFoodByDog += Number(input[i]);

        totalEatenFood += Number(input[i+1]);
        totalEatenFoodByCat += Number(input[i+1]);

        if(currentDay % 3 == 0){
            totalEatenBiscuits += Number(input[i]*0.1);
            totalEatenBiscuits += Number(input[i+1]*0.1);
        }
        i+=2;
        currentDay++;
    }

    console.log(`Total eaten biscuits: ${Math.round(totalEatenBiscuits)}gr.`);
    console.log(`${((totalEatenFood/totalFood)*100).toFixed(2)}% of the food has been eaten.`);
    console.log(`${((totalEatenFoodByDog/totalEatenFood)*100).toFixed(2)}% eaten from the dog.`);
    console.log(`${((totalEatenFoodByCat/totalEatenFood)*100).toFixed(2)}% eaten from the cat.`);
}

foodForPets(["3",
"500",
"100",
"30",
"110",
"25",
"120",
"35"])
;