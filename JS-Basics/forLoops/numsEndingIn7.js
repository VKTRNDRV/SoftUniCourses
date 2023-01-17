function numsEndingIn7(){
    let num = 1;
    let numString = String(num);

    for(let i = 1; i <= 1000; i++){
        if(numString.lastIndexOf("7") == numString.length - 1){
            console.log(num);
        }
        num++;
        numString = String(num);
    }
}

numsEndingIn7();