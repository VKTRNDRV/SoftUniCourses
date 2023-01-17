function fitnessCard(input){

    let startSum = Number(input[0]);
    let gender = String(input[1]);
    let age = Number(input[2]);
    let sport = String(input[3]);

    let agePriceAdjustment = 1;

    let excessCash = 0;

    let cardPrice = 0;

    //calc cardPrice
    switch(sport){
        case "Gym":
            if(gender === "m"){
                cardPrice = 42;
            }else if(gender === "f"){
                cardPrice = 35;
            }
            break;
        case "Boxing":
            if(gender === "m"){
                cardPrice = 41;
            }else if(gender === "f"){
                cardPrice = 37;
            }
            break;
        case "Yoga":
            if(gender === "m"){
                cardPrice = 45;
            }else if(gender === "f"){
                cardPrice = 42;
            }
            break;
        case "Zumba":
            if(gender === "m"){
                cardPrice = 34;
            }else if(gender === "f"){
                cardPrice = 31;
            }
            break;
        case "Dances":
            if(gender === "m"){
                cardPrice = 51;
            }else if(gender === "f"){
                cardPrice = 53;
            }
            break;
        case "Pilates":
            if(gender === "m"){
                cardPrice = 39;
            }else if(gender === "f"){
                cardPrice = 37;
            }
            break;
        default:
            break;
    }

    //calc agePriceAdjustment
    if(age <= 19){
        agePriceAdjustment -= 0.2;
    }

    cardPrice = cardPrice*agePriceAdjustment;

    excessCash = startSum - cardPrice;

    if(excessCash >= 0){
        console.log(`You purchased a 1 month pass for ${sport}.`)
    }else{
        console.log(`You don't have enough money! You need $${((excessCash*(-1)).toFixed(2))} more.`)
    }
}


fitnessCard(["20",
"f",
"15",
"Yoga"]);