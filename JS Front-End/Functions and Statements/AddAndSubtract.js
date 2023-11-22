function addAndSubtract(firstNum, secondNum, thirdNum){

    function sum(num1, num2){
        return num1 + num2;    
    }

    return sum(firstNum, secondNum) - thirdNum;
}

console.log(addAndSubtract(23,
    6,
    10
    )
    );

console.log(addAndSubtract(1,
    17,
    30
    )
    );
console.log(addAndSubtract(42,
    58,
    100    
    )
    );

