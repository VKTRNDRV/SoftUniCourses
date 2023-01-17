function tennisRanklist(input){
    let numOfTrnmntsPlayed = Number(input[0]);
    let initialPoints = Number(input[1]);

    let totalPoints = initialPoints;
    let avgPoints = 0;

    let trnmntsWon = 0;
    let percentTrnmntsWon = 0;

    const trnmntPlacing = input;
    trnmntPlacing.shift();
    trnmntPlacing.shift();
    
    //calculating totalPoints && trnmntsWon
    for(i = 0; i <= (trnmntPlacing.length - 1); i++){
        switch(trnmntPlacing[i]){
            case "W":
                totalPoints += 2000;
                trnmntsWon += 1;
                break;

            case "F":
                totalPoints += 1200;
                break;

            case "SF":
                totalPoints += 720;
                break;

            default:
                break;
        }
    }

    avgPoints = (totalPoints - initialPoints) / numOfTrnmntsPlayed;
    percentTrnmntsWon = trnmntsWon / numOfTrnmntsPlayed;

    console.log(`Final points: ${totalPoints}`);
    console.log(`Average points: ${Math.floor(avgPoints)}`);
    console.log(`${(percentTrnmntsWon*100).toFixed(2)}%`);
}

tennisRanklist(["7",
"1200",
"SF",
"F",
"W",
"F",
"W",
"SF",
"W"])
;
