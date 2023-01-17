function oscarsPoints(input){

    let actorName = String(input[0]);
    let academyPoints = Number(input[1]);
    let numOfJudges = Number(input[2]);

    const judgesAndPoints = input;
    judgesAndPoints.shift();
    judgesAndPoints.shift();
    judgesAndPoints.shift();

    let judgePoints = 0;
    let totalPoints = academyPoints;

    for(let i = 0; i <= (judgesAndPoints.length)-1; i+=2){
        let judgeName = String(judgesAndPoints[i]);
        let currentJudgePoints = Number(judgesAndPoints[i+1]);

        totalPoints = totalPoints + ((judgeName.length * currentJudgePoints) / 2);
        

        if(totalPoints >= 1250.5){
            console.log(`Congratulations, ${actorName} got a nominee for leading role with ${totalPoints.toFixed(1)}!`);
            break;
        }
    }

    if(totalPoints < 1250.5){
        console.log(`Sorry, ${actorName} you need ${(1250.5 - totalPoints).toFixed(1)} more!`);
    }

}
oscarsPoints(["Sandra Bullock",
"340",
"5",
"Robert De Niro",
"50",
"Julia Roberts",
"40.5",
"Daniel Day-Lewis",
"39.4",
"Nicolas Cage",
"29.9",
"Stoyanka Mutafova",
"33"])
;