function toyShop(input){
    let tripPrice = Number(input[0]);

    let puzzleQty = Number(input[1]);
    let dollQty = Number(input[2]);
    let bearQty = Number(input[3]);
    let minionQty = Number(input[4]);
    let truckQty = Number(input[5]);

    let totalQty = puzzleQty + dollQty + bearQty + minionQty + truckQty;

    let puzzlePrice = 2.6;
    let dollPrice = 3;
    let bearPrice = 4.1;
    let minionPrice = 8.20;
    let truckPrice = 2;

    let totalPrice = puzzleQty*puzzlePrice + dollQty*dollPrice + bearQty*bearPrice + minionQty*minionPrice + truckQty*truckPrice;
    

    if(totalQty >= 50){
        totalPrice = totalPrice*0.75;
    }

    let revenue = totalPrice*0.9;

    let cashAfterTrip = revenue - tripPrice;

    if(cashAfterTrip >= 0){
        let resultString = cashAfterTrip.toFixed(2);

        console.log("Yes! " + resultString + " lv left.")
    }else{//cashAfterTrip < 0
        cashAfterTrip = cashAfterTrip*(-1);

        let resultString = cashAfterTrip.toFixed(2);

        console.log("Not enough money! " + resultString + " lv needed.");
    }



}

toyShop(["320",
"8",
"2",
"5",
"5",
"1"])
;