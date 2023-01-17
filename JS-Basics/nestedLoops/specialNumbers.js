function specialNumbers(input){
    let num = Number(input[0]);

    let outputString = "";

    for(let n = 1111; n <= 9999; n++){
        let currentNum = String(n);
        let isSpecial = false;

        for(let d = 0; d < currentNum.length; d++){
            if(num % Number(currentNum[d]) == 0){
                isSpecial = true;
            }else{
                isSpecial = false;
                break;
            }
        }
        if(isSpecial == true){
            outputString += currentNum + " ";
        }
    }
    
    console.log(outputString);
}

specialNumbers(["17"]);