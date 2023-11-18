function sameNumbers(number){
    let numStr = number.toString();
    let isSame = true;
    let firstDigit = parseInt(numStr.charAt(0));
    let sum = firstDigit;
    let currentDigit;
    for(let i = 1; i < numStr.length; i++){
        currentDigit = parseInt(numStr.charAt(i));
        sum += currentDigit;
        
        if(!isSame){
            continue;
        }

        if(currentDigit !== firstDigit){
            isSame = false;
        }
    }

    console.log(isSame);
    console.log(sum);
}

sameNumbers(2222222);
sameNumbers(1234);