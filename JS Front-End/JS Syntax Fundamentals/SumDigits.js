function sumDigits(num){
    let sumOfDigits = 0;
    let numString = Math.abs(num).toString();
    let digit;
    for(let d = 0; d < numString.length; d++){
        sumOfDigits += parseInt(numString.charAt(d));
    } 

    console.log(sumOfDigits);
}

sumDigits(245678);
sumDigits(97561);
sumDigits(543);