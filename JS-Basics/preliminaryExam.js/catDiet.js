function catDiet(input){

    let percentFat = Number(input[0]) / 100;
    let percentProtein = Number(input[1]) / 100;
    let percentCarbs = Number(input[2]) / 100;
    let totalCalories = Number(input[3]);
    let percentWater = Number(input[4]) / 100;

    let caloriesPerGramFat = 9;
    let caloriesPerGramProtein = 4;
    let caloriesPerGramCarbs = 4;

    let caloriesPerGramFood = 0;

    let gramsOfFat = (totalCalories*percentFat) / caloriesPerGramFat;
    let gramsOfProtein = (totalCalories*percentProtein) / caloriesPerGramProtein;
    let gramsOfCarbs = (totalCalories*percentCarbs) / caloriesPerGramCarbs;

    let totalWeightGrams = (gramsOfFat + gramsOfProtein + gramsOfCarbs);

    caloriesPerGramFood = (totalCalories) / (totalWeightGrams);

    caloriesPerGramFood = caloriesPerGramFood * (1 - percentWater);

    console.log(caloriesPerGramFood.toFixed(4));
}

catDiet(["20",
"60",
"20",
"1800",
"50"])
;