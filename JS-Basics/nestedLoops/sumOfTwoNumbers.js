function sumOfTwoNumbers(input){

    let minNum = Number(input[0]);
    let maxNum = Number(input[1]);

    let magicNum = Number(input[2]);

    let comboCount = 0;
    let isComboFound = false;

    for(let a = minNum; a <= maxNum; a++){
        if(isComboFound == true){
            break;
        }
        for(let b = minNum; b <= maxNum; b++){
            if(isComboFound == true){
                break;
            }

            if(a + b != magicNum){
                comboCount++;
            }else{
                comboCount++;
                isComboFound = true;
                console.log(`Combination N:${comboCount} (${a} + ${b} = ${magicNum})`);
            }
        }
    }

    if(isComboFound == false){
        console.log(`${comboCount} combinations - neither equals ${magicNum}`)
    }
}

sumOfTwoNumbers(["23",
"24",
"20"])
;