function maxNumber(input){

    let maxNum = Number(input[0]);

    let index = 0;
    while(input[index] != "Stop"){
        if(Number(input[index]) > maxNum){
            maxNum = Number(input[index]);
        }
        index++
    }
    console.log(maxNum)
}

maxNumber(["-1",
"-2",
"Stop"])
;