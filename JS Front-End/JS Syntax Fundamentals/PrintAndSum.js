function printAndSum(firstNum, secondNum){
    if(firstNum > secondNum){
        let temp = firstNum;
        firstNum = secondNum;
        secondNum = temp;
    }

    let sum = 0;
    let numLine = ""
    while(firstNum <= secondNum){
        sum += firstNum;
        numLine += (firstNum + " ");
        firstNum++;
    }

    console.log(numLine);
    console.log("Sum: " + sum);
}

printAndSum(5, 10);
printAndSum(0, 26);
printAndSum(50, 60);