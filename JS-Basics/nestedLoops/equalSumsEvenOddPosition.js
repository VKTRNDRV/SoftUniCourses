function equalSumsEvenOddPosition(input){

    let minNumber = Number(input[0]);
    let maxNumber = Number(input[1]);

    let isResultFound = false;

    let outputString = "";

    for(let cn = minNumber; cn <= maxNumber; cn++){
        let currentNum = String(cn);
        let checker = 0;
        
        for(let digitIndex = 0; digitIndex < currentNum.length; digitIndex++){
            if((digitIndex+1) % 2 == 0){
                checker += Number(currentNum[digitIndex]);
            }else{
                checker -= Number(currentNum[digitIndex]);
            }            
        }

        if(checker == 0){
            isResultFound = true;
            outputString += currentNum + " ";
        }
        checker = 0;
    }

    if(isResultFound == true){
        console.log(outputString);
    }

}

equalSumsEvenOddPosition(["123456",
"124000"])
;