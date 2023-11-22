function printOddAndEvenSums(number){
    let numberStr = number.toString();

    let sumOdds = 0;
    let sumEvens = 0;

    for(let i = 0; i < numberStr.length; i++){
    
        let digit = Number.parseInt(numberStr.charAt(i));

        if(digit % 2 == 0){
            sumEvens += digit;
        }else{
            sumOdds += digit;
        }
    }

    console.log(`Odd sum = ${sumOdds}, Even sum = ${sumEvens}`);
}


printOddAndEvenSums(1000435);
printOddAndEvenSums(3495892137259234);