function careForPuppy(input){

    let foodSupplyGrams = Number(input[0]) * 1000;
    let foodEatenGrams = 0;

    input.shift();

    let i = 0;
    while(input[i] != "Adopted"){

        foodEatenGrams += Number(input[i]);

        i++;
    }

    if(foodEatenGrams <= foodSupplyGrams){
        console.log(`Food is enough! Leftovers: ${foodSupplyGrams-foodEatenGrams} grams.`);
    }else{
        console.log(`Food is not enough. You need ${foodEatenGrams - foodSupplyGrams} grams more.`);
    }
}

careForPuppy(["2",
"999",
"456",
"999",
"999",
"123",
"456",
"Adopted"])
;