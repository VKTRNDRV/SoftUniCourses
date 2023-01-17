function fishtankCalculator(input){
    let lengthInCM = Number(input[0]);
    let widthInCM = Number(input[1]);
    let heightInCM = Number(input[2]);
    let percentFull = Number(input[3]) / 100;

    let totalVolumeCubicCM = lengthInCM * widthInCM * heightInCM
    let emptyVolumeCubicCM = totalVolumeCubicCM * (1 - percentFull)

    let litersPerCubicCM = 0.001 

    let litersRequried = emptyVolumeCubicCM * litersPerCubicCM;

    console.log(litersRequried);

}

fishtankCalculator(["85","75","47","17"]);