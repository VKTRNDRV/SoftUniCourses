function cleverLilly(input){

    let age = Number(input[0]);
    let washingMachinePrice = Number(input[1]);
    let toyPrice = Number(input[2]);

    let birthdayMoneySaved = 0;
    let toysMoneySaved = 0;
    let totalMoneySaved;

    //calculating toysMoneySaved
    for(let i = 1; i <= age; i+=2){
        toysMoneySaved += toyPrice;
    }

    //calculating birthdayMoneySaved
    for(let i = 2; i <= age; i+=2){
        birthdayMoneySaved += ((10*(i/2)) - 1);
    }

    totalMoneySaved = birthdayMoneySaved + toysMoneySaved;

    if(totalMoneySaved >= washingMachinePrice){
        console.log(`Yes! ${(totalMoneySaved-washingMachinePrice).toFixed(2)}`);

    }else{
        console.log(`No! ${(washingMachinePrice - totalMoneySaved).toFixed(2)}`);
    }

}

cleverLilly(["21",
"1570.98",
"3"])
;