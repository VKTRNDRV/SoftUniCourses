function sumOfNumbers(input){
    let numberString = String(input[0]);
    let sum = 0;
    let digit;

    for(let i = 0; i < numberString.length; i++){
        digit = Number(numberString[i]);

        sum = sum + digit;
    }

    console.log(`The sum of the digits is:${sum}`);
}

sumOfNumbers(["564891"]);