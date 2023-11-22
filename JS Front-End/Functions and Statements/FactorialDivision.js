function printDivisionOfFactorialsOf(firstNum, secondNum){

    function getFactorial(num){
        if(num <= 1){
            return 1;
        }

        return num * getFactorial(num - 1);
    }

    let result = getFactorial(firstNum) / getFactorial(secondNum);
    console.log(result.toFixed(2));
}

printDivisionOfFactorialsOf(5, 2);
printDivisionOfFactorialsOf(6, 2);