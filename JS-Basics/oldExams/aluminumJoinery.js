function aluminumJoinery(input){

    let numOfItems = Number(input[0]);
    let numOfItemsPriceAdjustment = 1;
    let extraPriceAdjustment = 1;

    let sizeOfItems = String(input[1]);
    let itemPrice = 0;

    let requestDelivery = String(input[2]);
    let deliveryPrice = 60;
    let isDeliveryOrdered = false;

    let totalPrice = 0;

    //calculating isDeliveryOrdered
    switch(requestDelivery){
        case "With delivery":
            isDeliveryOrdered = true;
            break;
        case "Without delivery":
            isDeliveryOrdered = false;
            break;
        default:
            break;
    }

    //caluclating itemPrice
    switch(sizeOfItems){
        case "90X130":
            itemPrice = 110
            break;
        case "100X150":
            itemPrice = 140
            break;
        case "130X180":
            itemPrice = 190
            break;
        case "200X300":
            itemPrice = 250;
            break;
        default:
            break;
    }

    //calculating numOfItemsPriceAdjustment
    switch(sizeOfItems){
        case "90X130":
            if(numOfItems <= 30){

            }else if(numOfItems > 30 && numOfItems <= 60){
                numOfItemsPriceAdjustment -= 0.05;
            }else if(numOfItems > 60){
                numOfItemsPriceAdjustment -= 0.08;
            }
            break;
        case "100X150":
            if(numOfItems <= 40){

            }else if(numOfItems > 40 && numOfItems <= 80){
                numOfItemsPriceAdjustment -= 0.06;
            }else if(numOfItems > 80){
                numOfItemsPriceAdjustment -= 0.1;
            }
            break;
        case "130X180":
            if(numOfItems <= 20){

            }else if(numOfItems > 20 && numOfItems <= 50){
                numOfItemsPriceAdjustment -= 0.07;
            }else if(numOfItems > 50){
                numOfItemsPriceAdjustment -= 0.12;
            }
            break;
        case "200X300":
            if(numOfItems <= 25){

            }else if(numOfItems > 25 && numOfItems <= 50){
                numOfItemsPriceAdjustment -= 0.09;
            }else if(numOfItems > 50){
                numOfItemsPriceAdjustment -= 0.14;
            }
            break;
        default:
            break;
    }

    //calculating extraPriceAdjustment
    if(numOfItems > 99){
        extraPriceAdjustment -= 0.04;
    }

    //calculating totalPrice
    if(isDeliveryOrdered == true){
        totalPrice = (((numOfItems*itemPrice)*numOfItemsPriceAdjustment)+deliveryPrice)*extraPriceAdjustment;
    }else{
        totalPrice = ((numOfItems*itemPrice)*numOfItemsPriceAdjustment)*extraPriceAdjustment;
    }

    if(numOfItems <= 10){
        console.log("Invalid order");
    }else{
        console.log(`${totalPrice.toFixed(2)} BGN`)
    }
}

aluminumJoinery(["3",
"100X150",
"With delivery"]);