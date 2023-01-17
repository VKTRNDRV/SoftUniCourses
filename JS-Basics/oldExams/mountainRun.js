function mountainRun(input){

    let recordTimeSeconds = Number(input[0]);
    let distanceMeters = Number(input[1]);
    let secondsPerMeter = Number(input[2]);
    let slowdownSeconds = (Math.floor(distanceMeters/50))*30;

    let attemptTimeSeconds = (distanceMeters * secondsPerMeter) + slowdownSeconds;

    if(attemptTimeSeconds < recordTimeSeconds){
        console.log(`Yes! The new record is ${attemptTimeSeconds.toFixed(2)} seconds.`)
    }else{
        console.log(`No! He was ${(attemptTimeSeconds - recordTimeSeconds).toFixed(2)} seconds slower.`);
    }
}

mountainRun(["1377",
"389",
"3"])
;