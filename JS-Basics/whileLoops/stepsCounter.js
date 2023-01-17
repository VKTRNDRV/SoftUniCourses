function stepsCounter(input){

    let targetSteps = 10000;

    let totalSteps = 0;

    let index = 0;
    while(index < input.length){
        if(input[index] == "Going home"){
            index++;
        }
        totalSteps += Number(input[index]);
        index++
    }

    if(totalSteps >= targetSteps){
        console.log(`Goal reached! Good job!`);
        console.log(`${totalSteps - targetSteps} steps over the goal!`);

    }else{
        console.log(`${targetSteps - totalSteps} more steps to reach goal.`);
    }
}



stepsCounter(["125",
"250",
"4000",
"30",
"2678",
"4682"])
;