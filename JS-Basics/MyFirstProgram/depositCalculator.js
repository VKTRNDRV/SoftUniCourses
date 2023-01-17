function depositCalculator(input){
    let depositSum = Number(input[0]);
    let depositLengthMonths = Number(input[1]);
    let depositRateYear = Number(input[2]);

    let yearlyInterest = depositSum * depositRateYear / 100;
    let monthlyInterest = yearlyInterest / 12;

    let endSum = depositSum + (depositLengthMonths * monthlyInterest);

    console.log(endSum);
}

depositCalculator(["200", "3", "5.7"]);