function repaintingCalculator(input){
    let nylonSqMetersRequired = Number(input[0]);
    let paintLitersRequired = Number(input[1]);
    let solventLitersRequired = Number(input[2]);
    let hoursOfLaborRequired = Number(input[3]);

    let nylonPricePerSqM = 1.5;
    let paintPricePerSqM = 14.5;
    let solventPricePerL = 5;
    let bagsPrice = 0.4;

    let nylonSqMetersPrepared = nylonSqMetersRequired + 2;
    let paintLitersPrepared = paintLitersRequired * 1.1;

    let suppliesTotalPrice = nylonSqMetersPrepared*nylonPricePerSqM + paintLitersPrepared*paintPricePerSqM + solventLitersRequired*solventPricePerL + bagsPrice;

    let laborPricePerHour = suppliesTotalPrice * 0.3;
    let laborTotalPrice = laborPricePerHour * hoursOfLaborRequired;
    
    let totalPrice = suppliesTotalPrice + laborTotalPrice;

    console.log(totalPrice);
}

repaintingCalculator(["10","11","4","8"]);