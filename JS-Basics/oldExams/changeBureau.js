function changeBureau(input){

    let BTCtoBGN = 1168;
    let CYNtoUSD = 0.15;
    let USDtoBGN = 1.76;
    let EURtoBGN = 1.95;

    let BTC_amount = Number(input[0]);
    let CYN_amount = Number(input[1]);
    let commissionPriceAdjustment = 1 - (Number(input[2])/100);

    let EUR_amount = (BTC_amount*BTCtoBGN*(1/EURtoBGN)) + (CYN_amount*CYNtoUSD*USDtoBGN*(1/EURtoBGN));

    let finalOutput = EUR_amount*commissionPriceAdjustment;
    
    console.log(finalOutput.toFixed(2));
}

changeBureau(["20","5678","2.4"]);