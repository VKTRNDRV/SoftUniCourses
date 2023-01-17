function coffeeMachine(input){

    let typeOfDrink = String(input[0]);
    let sugarLevel = String(input[1]);
    let numOfDrinks = Number(input[2]);

    let drinkPrice = 0;
    switch(typeOfDrink){

        case "Espresso":
            switch(sugarLevel){
                case "Without":
                    drinkPrice = 0.9;
                    break;
                case "Normal":
                    drinkPrice = 1;
                    break;
                case "Extra":
                    drinkPrice = 1.2;
                    break;
                default:
                    break;
            }
            break;

        case "Cappuccino":
            switch(sugarLevel){
                case "Without":
                    drinkPrice = 1;
                    break;
                case "Normal":
                    drinkPrice = 1.2;
                    break;
                case "Extra":
                    drinkPrice = 1.6;
                    break;
                default:
                    break;
            }
            break;

        case "Tea":
            switch(sugarLevel){
                case "Without":
                    drinkPrice = 0.5;
                    break;
                case "Normal":
                    drinkPrice = 0.6;
                    break;
                case "Extra":
                    drinkPrice = 0.7;
                    break;
                default:
                    break;
            }
            break;

        default:
            break;
    }

    let sugarDiscount = 1;
    if(sugarLevel === "Without"){
        sugarDiscount = 0.65;
    }

    let espressoDiscount = 1;
    if(typeOfDrink === "Espresso" && numOfDrinks >= 5){
        espressoDiscount = 0.75;
    }

    let totalPrice = (numOfDrinks * (drinkPrice*sugarDiscount))*espressoDiscount;
    if(totalPrice > 15){
        totalPrice *= 0.8;
    }

    console.log(`You bought ${numOfDrinks} cups of ${typeOfDrink} for ${totalPrice.toFixed(2)} lv.`)
}

coffeeMachine(["Tea",
"Extra",
"3"])
;