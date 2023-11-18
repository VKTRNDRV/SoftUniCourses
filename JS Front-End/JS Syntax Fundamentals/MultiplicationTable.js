function multiplicationTable(num){
    let multiplier = 1;
    while(multiplier <= 10){
        console.log(`${num} X ${multiplier} = ${num * multiplier}`);
        multiplier++;
    }
}

multiplicationTable(5);
multiplicationTable(2);