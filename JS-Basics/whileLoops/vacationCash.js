function vacationCash(input){

    let moneyNeeded = Number(input[0]);
    let initialMoney = Number(input[1]);
    input.shift();
    input.shift();

    let moneyBalance = initialMoney;

    let dayCount = 0;
    let spendCount = 0;

    index = 0;
    while(index < input.length){
        switch(input[index]){
            case "spend":
                if(Number(input[index+1]) > moneyBalance){
                    moneyBalance = 0;
                }else{
                    moneyBalance -= Number(input[index+1]);
                }
                spendCount++;
                dayCount++;
                break;

            case "save":
                moneyBalance += Number(input[index+1]);
                spendCount = 0;
                dayCount++;
                break;

            default:
                break;
        }

        if(moneyBalance >= moneyNeeded){
            console.log(`You saved the money for ${dayCount} days.`);
            break;
        }

        if(spendCount >= 5){
            console.log(`You can't save the money.`);
            console.log(dayCount);
        }

        index += 2;
    }

}

vacationCash(["2000",
"1000",
"spend",
"1200",
"save",
"2000"])
;