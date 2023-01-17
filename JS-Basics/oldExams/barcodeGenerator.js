function barcodeGenerator(input){

    let minNum = String(input[0]);
    let maxNum = String(input[1]);

    let outputString = "";

    for(let n = Number(minNum); n <= Number(maxNum); n++){
        let isOK = false;
        let currentNumber = String(n);

        for(let d = 0; d < currentNumber.length; d++){
            let currentDigit = Number(currentNumber[d]);

            if(currentDigit >= Number(minNum[d]) && currentDigit <= Number(maxNum[d])){
                if(currentDigit % 2 == 1){
                    isOK = true;
                }else{
                    isOK = false;
                    break;
                }
            }else{
                isOK = false;
                break;
            }
        }

        if(isOK == true){
            outputString += currentNumber + " ";
        }
    }
    console.log(outputString);
}

barcodeGenerator(["1365",
"5877"]);