function hotelRoom(input){
    let month  = String(input[0]);
    let daysBooked = Number(input[1]);

    let apInitialPrice;
    let apPriceAdjustment = 1;
    let apFinalPrice;
    let apStayPrice;

    let studioInitialPrice;
    let studioPriceAdjustment = 1;
    let studioFinalPrice;
    let studioStayPrice;

    switch(month){ //calculating PriceAdjustments & FinalPrices
        case "May":
        case "October":
            apInitialPrice = 65;
            studioInitialPrice = 50;

            if(daysBooked <= 7){
                apFinalPrice = apInitialPrice * apPriceAdjustment;
                studioFinalPrice = studioInitialPrice * studioPriceAdjustment;

            }else if(daysBooked > 7 && daysBooked <= 14){
                studioPriceAdjustment = studioPriceAdjustment - 0.05;

                apFinalPrice = apInitialPrice * apPriceAdjustment;
                studioFinalPrice = studioInitialPrice * studioPriceAdjustment;

            } else if(daysBooked > 14){
                studioPriceAdjustment = studioPriceAdjustment - 0.30;
                apPriceAdjustment = apPriceAdjustment - 0.1;

                apFinalPrice = apInitialPrice * apPriceAdjustment;
                studioFinalPrice = studioInitialPrice * studioPriceAdjustment;

            }
            break;

        case "June":
        case "September":
            apInitialPrice = 68.7;
            studioInitialPrice = 75.2;

            if(daysBooked <= 14){
                apFinalPrice = apInitialPrice * apPriceAdjustment;
                studioFinalPrice = studioInitialPrice * studioPriceAdjustment;

            } else if(daysBooked > 14){
                studioPriceAdjustment = studioPriceAdjustment - 0.2;
                apPriceAdjustment = apPriceAdjustment - 0.1;


                apFinalPrice = apInitialPrice * apPriceAdjustment;
                studioFinalPrice = studioInitialPrice * studioPriceAdjustment;

            }
            break;

        case "July":
        case "August":
            apInitialPrice = 77;
            studioInitialPrice = 76;

            if(daysBooked <= 14){
                apFinalPrice = apInitialPrice * apPriceAdjustment;
                studioFinalPrice = studioInitialPrice * studioPriceAdjustment;

            } else if(daysBooked > 14){
                apPriceAdjustment = apPriceAdjustment - 0.1;

                apFinalPrice = apInitialPrice * apPriceAdjustment;
                studioFinalPrice = studioInitialPrice * studioPriceAdjustment;
            }
            break;

        default:
            break;
    }

    apStayPrice = apFinalPrice * daysBooked;
    studioStayPrice = studioFinalPrice * daysBooked

    console.log("Apartment: " + apStayPrice.toFixed(2) + " lv.");
    console.log("Studio: " + studioStayPrice.toFixed(2) + " lv.");
    
}

hotelRoom(["June",
"14"])
;