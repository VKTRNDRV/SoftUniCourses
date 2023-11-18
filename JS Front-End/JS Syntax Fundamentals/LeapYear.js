function isLeapYear(year){
    if(year % 400 === 0){
        console.log("yes");
        return;
    }

    if(year % 4 === 0 && year % 100 !== 0){
        console.log("yes");
        return;
    }

    console.log("no");
}

isLeapYear(1984);
isLeapYear(2003);
isLeapYear(4);