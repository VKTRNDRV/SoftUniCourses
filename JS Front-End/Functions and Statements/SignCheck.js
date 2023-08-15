function checkSign(numOne, numTwo, numThree){
    if(numOne == 0 || numTwo == 0 || numThree == 0){
        console.log("Zero");
        return;
    }
    
    let negativesCount = 0;
    if(numOne < 0){
        negativesCount++;
    }
    if(numTwo < 0){
        negativesCount++;
    }
    if(numThree < 0){
        negativesCount++;
    }

    if(negativesCount % 2 == 0){
        console.log("Positive");
    }else{
        console.log("Negative");
    }
}


checkSign(5, 12, -15);
checkSign(5, -12, -15);
checkSign(-5, -12, -15);
checkSign(5, 0, -15);