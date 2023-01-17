function skiTrip(input){

    let daysStayed = Number(input[0]);
    let nightsBooked = daysStayed - 1;

    let roomType = String(input[1]);
    let pricePerNightInitial;
    let priceAdjustment = 1;
    let totalPrice;

    let evaluation = String(input[2]);



    //calculating priceAdjustment(daysStayed) && pricePerNightInitial
    switch(roomType){
        case "room for one person":
            pricePerNightInitial = 18;
            break;

        case "apartment":
            pricePerNightInitial = 25;

            if(daysStayed <= 9){
                priceAdjustment = priceAdjustment * (1 - 0.3);

            }else if(daysStayed >= 10 && daysStayed <= 15){
                priceAdjustment = priceAdjustment * (1 - 0.35);

            }else if(daysStayed >= 16){
                priceAdjustment = priceAdjustment * (1 - 0.5);

            }
            break;

        case "president apartment":
            pricePerNightInitial = 35;
            
            if(daysStayed <= 9){
                priceAdjustment = priceAdjustment * (1 - 0.1);

            }else if(daysStayed >= 10 && daysStayed <= 15){
                priceAdjustment = priceAdjustment * (1 - 0.15);

            }else if(daysStayed >= 16){
                priceAdjustment = priceAdjustment * (1 - 0.2);

            }
            break;

        default:
            break;
    }



    //calculating priceAdjustment(evaluation)
    switch(evaluation){
        case "positive":
            priceAdjustment = priceAdjustment * (1 + 0.25);
            break;
        case "negative":
            priceAdjustment = priceAdjustment * (1 - 0.1);
            break;
        default:
            break;
    }

    totalPrice = pricePerNightInitial * nightsBooked * priceAdjustment;

    console.log(totalPrice.toFixed(2));

}
skiTrip(["2",
"apartment",
"positive"])
;

