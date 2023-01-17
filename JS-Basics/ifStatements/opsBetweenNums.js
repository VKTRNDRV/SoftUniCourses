function opsBetweenNums(input){
    let num1 = Number(input[0]);
    let num2 = Number(input[1]);
    let operator = String(input[2]);
    let result;
    let evenOrOdd;
    
    switch(operator){
        case "+":
            result = num1 + num2;
            if(result % 2 === 0){
                evenOrOdd = "even";
            }else{
                evenOrOdd = "odd";
            }
            console.log(num1 + " + " + num2 + " = " + result + " - " + evenOrOdd);
            break;

        case "-":
            result = num1 - num2;
            if(result % 2 === 0){
                evenOrOdd = "even";
            }else{
                evenOrOdd = "odd";
            }
            console.log(num1 + " - " + num2 + " = " + result + " - " + evenOrOdd);
            break;

        case "*":
            result = num1 * num2;
            if(result % 2 === 0){
                evenOrOdd = "even";
            }else{
                evenOrOdd = "odd";
            }
            console.log(num1 + " * " + num2 + " = " + result + " - " + evenOrOdd);
            break;
        case "/":
            if(num2 == 0){ //dividing by 0
                console.log("Cannot divide " + num1 + " by zero");
            }else{
                result = num1 / num2;

                console.log(num1 + " / " + num2 + " = " + result.toFixed(2));
            }

            break;
        case "%":
            if(num2 == 0){ //dividing by 0
                console.log("Cannot divide " + num1 + " by zero")
            }else{
                result = num1 % num2;

                console.log(num1 + " % " + num2 + " = " + result);
            }

            break;
        default:
            break;
    }
}
opsBetweenNums(["10",
"0",
"%"])
;