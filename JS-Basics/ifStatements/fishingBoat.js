function fishingBoat(input){

    let budget = Number(input[0]);
    let leftoverCash;

    let season = String(input[1]);
    let numOfFishermen = Number(input[2]);

    let boatRentInitial;
    let priceAdjustment = 1;
    let boatRentFinal;

    switch(season){ //calculating boatRentInitial
        case "Spring":
            boatRentInitial = 3000;
            break;

        case "Summer":
        case "Autumn":
            boatRentInitial = 4200;
            break;

        case "Winter":
            boatRentInitial = 2600;
            break;
            default:
                break;
    }

    if(numOfFishermen <= 6){ // calculating numOfFishermen discount
        priceAdjustment = priceAdjustment - 0.1;

    }else if(numOfFishermen >= 7 && numOfFishermen <= 11){
        priceAdjustment = priceAdjustment - 0.15;

    }else if(numOfFishermen >= 12){
        priceAdjustment = priceAdjustment - 0.25;

    }

    if(numOfFishermen % 2 === 0 && season != "Autumn"){ // calculating 5% discount
        priceAdjustment = priceAdjustment * 0.95;
    }

    boatRentFinal = boatRentInitial * priceAdjustment;

    leftoverCash = budget - boatRentFinal;

    if(leftoverCash >= 0){
        console.log("Yes! You have " + leftoverCash.toFixed(2) + " leva left.")

    }else{
        leftoverCash = leftoverCash * (-1);
        console.log("Not enough money! You need " + leftoverCash.toFixed(2) + " leva.")
    }


}

fishingBoat(["3600",
"Autumn",
"6"])
;