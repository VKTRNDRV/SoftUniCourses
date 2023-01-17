function accountBalance(input){

    let balance = 0;

    let index = 0;
    while(index <= (input.length-1)){
        if(Number(input[index]) < 0){
            console.log("Invalid operation!");
            console.log(`Total: ${balance.toFixed(2)}`);
            break;
        }
        if(input[index] === "NoMoreMoney"){
            console.log(`Total: ${Number(balance).toFixed(2)}`);
            break;
        }

        console.log(`Increase: ${Number(input[index]).toFixed(2)}`);
        balance += Number(input[index]);

        index++;
    }
    
}

accountBalance(["5.51", 
"69.42",
"100",
"NoMoreMoney"])
;