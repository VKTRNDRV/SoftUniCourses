function addBags(input){

    let bagPriceOver20kg = Number(input[0]);
    let bagPriceOver10kg = bagPriceOver20kg * 0.5;
    let bagPriceOver0kg = bagPriceOver20kg * 0.2;

    let bagWeightKg = Number(input[1]);
    let bagPrice = 0;

    let daysInAdvance = Number(input[2]);
    let numOfBags = Number(input[3]);

    let priceAdjustment = 1;

    if(daysInAdvance < 7){
        priceAdjustment += 0.4;

    }else if(daysInAdvance >= 7 && daysInAdvance <= 30){
        priceAdjustment += 0.15;

    }else if(daysInAdvance > 30){
        priceAdjustment += 0.1;
    }

    if(bagWeightKg > 0 && bagWeightKg < 10){
        bagPrice = bagPriceOver0kg;

    }else if(bagWeightKg >= 10 && bagWeightKg <= 20){
        bagPrice = bagPriceOver10kg;

    }else if(bagWeightKg > 20){ 
        bagPrice = bagPriceOver20kg;

    }

    let totalPrice = (numOfBags*bagPrice)*priceAdjustment;

    console.log(`The total price of bags is: ${totalPrice.toFixed(2)} lv.`);
}

addBags(["30","18","15","2"]);