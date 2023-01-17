function sequence2KPlus1(input){

    let max = Number(input[0]);

    let k = 1;
    while(k <= max){
        console.log(k);
        k = k*2 + 1
    }
}
sequence2KPlus1(["31"]);