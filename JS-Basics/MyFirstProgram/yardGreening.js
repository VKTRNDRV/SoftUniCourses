function yardGreening(input){
    let yardArea = input;
    let pricePerSqMeter = 7.61;
    let discountRate = 0.18;

    let price = yardArea * pricePerSqMeter;

    let discount = price * discountRate;

    let finalPrice = price - discount;

    console.log("The final price is: " + finalPrice + " lv.");
    console.log("The discount is: " + discount + " lv.");



}

yardGreening(550);