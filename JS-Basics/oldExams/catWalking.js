function catWalking(input){

    let minsPerWalk = Number(input[0]);
    let walksPerDay = Number(input[1]);
    let calorieIntake = Number(input[2]);

    let caloriesBurnedPerMinute = 5;
    
    let caloriesBurned = minsPerWalk*walksPerDay*caloriesBurnedPerMinute;

    let isEnough = false;
    if(caloriesBurned >= (calorieIntake*0.5)){
        isEnough = true;
    }

    if(isEnough === true){
        console.log(`Yes, the walk for your cat is enough. Burned calories per day: ${caloriesBurned}.`);
    }else{
        console.log(`No, the walk for your cat is not enough. Burned calories per day: ${caloriesBurned}.`);
    }
}

catWalking(["15",
"2",
"500"])
;