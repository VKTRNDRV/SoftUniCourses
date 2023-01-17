function suppliesForSchool(input){
    let penPacketPrice = 5.8;
    let markerPacketPrice = 7.2;
    let boardCleanerPricePerL = 1.2;

    let penPacketsOrdered = Number(input[0]);
    let markerPacketsOrdered = Number(input[1]);
    let boardCleanerLitersOrdered = Number(input[2]);
    let discountRate = Number(input[3]);

    let penSumPrice = penPacketsOrdered*penPacketPrice;
    let markerSumPrice = markerPacketsOrdered*markerPacketPrice;
    let boardCleanerSumPrice = boardCleanerLitersOrdered*boardCleanerPricePerL

    let sumPrice = penSumPrice + markerSumPrice + boardCleanerSumPrice;

    let endPrice = sumPrice - (sumPrice * (discountRate / 100))

    //console.log(sumPrice);
    //console.log(discountRate/100);
    console.log(endPrice);

}

suppliesForSchool(["2", "3", "4", "25"]);