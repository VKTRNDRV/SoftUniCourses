function petShop(input){
    let dogFoodPrice = 2.5;
    let catFoodPrice = 4;

    let dogFoodQty = input[0];
    let catFoodQty = input[1];

    let total = dogFoodQty*dogFoodPrice + catFoodQty*catFoodPrice;
    
    let outputString = total + " lv."

    console.log(outputString);
}

petShop([13,9]);