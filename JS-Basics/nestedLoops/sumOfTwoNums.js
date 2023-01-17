function sumOfTwoNums(input){

    let minNum = Number(input[0]);
    let maxNum = Number(input[1]);
    let sum = Number(input[2]);

    let combCount = 0;
    let isValidFound = false;
    let validCombString = "";

    let num1 = minNum;
    while(num1 <= maxNum){

        let num2 = minNum;
        while(num2 <= maxNum){

            if(num1 + num2 == sum){
                validCombString = `${num1} + ${num2} = ${sum}`
                isValidFound = true;
                combCount++;
                break;
            }
            combCount++;
            num2++;
        }
        if(isValidFound == true){
            break;
        }
        num1++;
    }

    if(isValidFound == true){
        console.log(`Combination N:${combCount} (${validCombString})`)
    }else{
        console.log(`${combCount} combinations - neither equals ${sum}`)
    }

}

sumOfTwoNums(["88","888","2000"]);