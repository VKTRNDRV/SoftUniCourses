function godzillaVsKong(input){
    let movieBudget = Number(input[0]);
    let extrasNum = Number(input[1]);
    let clothesPrice = Number(input[2]);

    let decorBudget = movieBudget*0.1;

    let clothesBudget = extrasNum * clothesPrice;

    if(extrasNum > 150){
        clothesBudget = clothesBudget*0.9;
    }

    let totalSpending = decorBudget + clothesBudget;
    let difference = movieBudget - totalSpending;

    if(difference >= 0){
        let differenceString = difference.toFixed(2);

        console.log("Action!");
        console.log("Wingard starts filming with " + differenceString + " leva left.");

    }else{ //difference < 0
        difference = difference * (-1);
        let differenceString = difference.toFixed(2);

        console.log("Not enough money!");
        console.log("Wingard needs " + differenceString + " leva more.");
    }
}
godzillaVsKong(["9587.88",
"222",
"55.68"])


;