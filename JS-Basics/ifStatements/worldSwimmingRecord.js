function worldSwimmingRecord(input){
    let recordTimeSeconds = Number(input[0]);
    let lengthInMeters = Number(input[1]);
    let secondsToSwimMeter = Number(input[2]);

    let secondsAdded = Math.floor(lengthInMeters/15) * 12.5;

    let attemptTimeSeconds = (lengthInMeters * secondsToSwimMeter) + secondsAdded;

    let attemptDifference = recordTimeSeconds - attemptTimeSeconds;

    if (attemptDifference > 0){
        let attemptDifferenceString = attemptDifference.toFixed(2);

        console.log(" Yes, he succeeded! The new world record is " + attemptTimeSeconds.toFixed(2) + " seconds.");

    }else{
        attemptDifference = attemptDifference * (-1);

        let attemptDifferenceString = attemptDifference.toFixed(2);

        console.log("No, he failed! He was " + attemptDifferenceString + " seconds slower.");
    }
}

worldSwimmingRecord(["55555.67",
"3017",
"5.03"]);