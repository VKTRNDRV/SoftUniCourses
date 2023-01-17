function tournamentOfChristmas(input){

    let numOfDays = Number(input[0]);
    input.shift();

    let totalMoneyRaised = 0;
    let currentDayMoneyRaised = 0;
    let daysWinsMinusLosses = 0;
    let currentDayWinsMinusLosses = 0;

    let i = 0;
    while(i < input.length){

        if(input[i] == "Finish"){
            if(currentDayWinsMinusLosses > 0){
                totalMoneyRaised += (currentDayMoneyRaised * 0.1);
                daysWinsMinusLosses++;
            }else{
                daysWinsMinusLosses--;
            }
            currentDayWinsMinusLosses = 0;
            currentDayMoneyRaised = 0;
            i++;
        }
        switch(input[i+1]){
            case "win":
                currentDayWinsMinusLosses++;
                totalMoneyRaised += 20;
                currentDayMoneyRaised += 20;
                break;

            case "lose":
                currentDayWinsMinusLosses--;
                break;
            default:
                break;
        }
        i+=2;
    }

    if(daysWinsMinusLosses > 0){
        totalMoneyRaised *= 1.2;
        console.log(`You won the tournament! Total raised money: ${totalMoneyRaised.toFixed(2)}`);
    }else{
        console.log(`You lost the tournament! Total raised money: ${totalMoneyRaised.toFixed(2)}`);
    }
}

tournamentOfChristmas(["3",
"darts",
"lose",
"handball",
"lose",
"judo",
"win",
"Finish",
"snooker",
"lose","swimming",
"lose",
"squash",
"lose",
"table tennis",
"win",
"Finish",
"volleyball",
"win",
"basketball",
"win",
"Finish"]);