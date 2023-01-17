function converterRadToDeg(input){
    let radInput = input;

    let outputInDeg = radInput * (180 / Math.PI);

    console.log(outputInDeg);
}

converterRadToDeg(6.2832);