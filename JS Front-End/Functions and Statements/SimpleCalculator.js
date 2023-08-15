function calculate(numOne, numTwo, operator){
    let action;
    switch(operator){
        case "add": action = (a,b) => a + b; break;
        case "subtract": action = (a,b) => a - b; break;
        case "multiply": action = (a,b) => a * b; break;
        case "divide": action = (a,b) => a / b; break;
    }

    let result = action(numOne, numTwo);
    console.log(result);
}

calculate(5, 5, 'multiply');
calculate(40, 8, 'divide');
calculate(12, 19, 'add');
calculate(50, 13, 'subtract');