function travellingCalculator(input){

    let destination;

    let minBudget = 0;

    let currentBudget = 0;

    isResultPrinted = false;

    let i = 0;
    while(i < input.length){
        if(String(input[i]) == "End"){
            break;
        }
        if(isNaN(input[i]) == true){
            destination = String(input[i]);
            minBudget = Number(input[i+1]);
            currentBudget = 0;
            isResultPrinted = false;
            i+=2;
        }
        while(isNaN(input[i]) == false){
        currentBudget += Number(input[i]);
        i++;
        }

        if(currentBudget >= minBudget  && isResultPrinted == false){
            console.log(`Going to ${destination}!`);
            isResultPrinted = true;
        }

    }
}

travellingCalculator(["France",
"2000",
"300",
"300",
"200",
"400",
"190",
"258",
"360",
"Portugal",
"1450",
"400",
"400",
"200",
"300",
"300",
"Egypt",
"1900",
"1000",
"280",
"300",
"500",
"End"])
;