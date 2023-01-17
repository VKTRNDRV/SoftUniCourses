function energyBooster(input){

    let fruitSetOrdered = String(input[0]);
    let sizeSetOrdered = String(input[1]);
    let qtySetsOrdered = String(input[2]);

    let pricePerBooster = 0;
    let qtyBoostersPerSet = 0;

    let initialPrice = 0;
    let priceAdjustment = 1;

    //calc pricePerBooster
    switch(fruitSetOrdered){
        case "Watermelon":
            if(sizeSetOrdered == "small"){
                pricePerBooster = 56;
            }else{
                pricePerBooster = 28.7;
            }
            break;
        case "Mango":
            if(sizeSetOrdered == "small"){
                pricePerBooster = 36.66;
            }else{
                pricePerBooster = 19.6;
            }
            break;
        case "Pineapple":
            if(sizeSetOrdered == "small"){
                pricePerBooster = 42.1;
            }else{
                pricePerBooster = 24.8;
            }
            break;
        case "Raspberry":
            if(sizeSetOrdered == "small"){
                pricePerBooster = 20;
            }else{
                pricePerBooster = 15.2;
            }
            break;
        default:
            break;
    }

    //calc qtyBoostersPerSet
    switch(sizeSetOrdered){
        case "small":
            qtyBoostersPerSet = 2;
            break;
        case "big":
            qtyBoostersPerSet = 5;
            break;
        default:
            break;
    }

    initialPrice = qtySetsOrdered * qtyBoostersPerSet * pricePerBooster;

    //calc priceAdjustment
    if(initialPrice >= 400 && initialPrice <= 1000){
        priceAdjustment -= 0.15;
    }else if(initialPrice > 1000){
        priceAdjustment -= 0.5;
    }

    let finalPrice = initialPrice * priceAdjustment;

    console.log(`${finalPrice.toFixed(2)} lv.`);

}

energyBooster(["Mango",
"big",
"8"]);


