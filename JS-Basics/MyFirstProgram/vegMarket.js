function vegMarket(input){
    let vegPricePerKGinBGN = Number(input[0]);
    let fruitPricePerKGinBGN = Number(input[1]);
    let vegTotalKG = Number(input[2]);
    let fruitTotalKG = Number(input[3]);

    let BGNtoEUR = 1/(1.94)

    let totalRevenueInEUR = (vegTotalKG*vegPricePerKGinBGN + fruitTotalKG*fruitPricePerKGinBGN) * BGNtoEUR;

    console.log(totalRevenueInEUR.toFixed(2));
}

vegMarket(["0.194","19.4","10","10"])