function deerOfSanta(input){

    let numOfDaysAbsent = Number(input[0]);
    let totalFoodKG = Number(input[1]);
    let firstDeerDailyIntake = Number(input[2]);
    let secondDeerDailyIntake = Number(input[3]);
    let thirdDeerDailyIntake = Number(input[4]);

    let isFoodEnough = true;

    let totalNeededFood = numOfDaysAbsent * (firstDeerDailyIntake + secondDeerDailyIntake + thirdDeerDailyIntake);

    if(totalNeededFood > totalFoodKG){
        isFoodEnough = false;
    }

    if(isFoodEnough == true){
        console.log(`${Math.floor(totalFoodKG - totalNeededFood)} kilos of food left.`);
    }else{
        console.log(`${Math.ceil(totalNeededFood - totalFoodKG)} more kilos of food are needed.`);
    }
}

deerOfSanta(["5",
"10",
"2.1",
"0.8",
"11"])
;