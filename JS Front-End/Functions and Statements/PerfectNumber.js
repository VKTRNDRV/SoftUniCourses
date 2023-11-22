function printIsPerfect(number){
    let divisors = [];
    for(let i = 1; i < number; i++){
        if(number % i == 0){
            divisors.push(i);
        }
    }

    let sum = 0;
    divisors.forEach(d => sum += d);

    if(sum == number){
        console.log("We have a perfect number!");
    }else{
        console.log("It's not so perfect.");
    }
}

printIsPerfect(6);
printIsPerfect(28);
printIsPerfect(123123);