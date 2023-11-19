function printEveryNthElement(array, num){
    let output = [];
    for(let i = 0; i < array.length; i++){
        if(i % num == 0){
            output.push(array[i]);
        }
    }

    return output;
}


console.log(printEveryNthElement(['5','20','31','4','20'], 2));
console.log(printEveryNthElement(['dsa','asd','test','tset'], 2));
console.log(printEveryNthElement(['1','2','3','4','5'], 6));