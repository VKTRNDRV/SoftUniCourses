function printTotal(groupSize, groupType, dayOfWeek){
    function getDayIndex(day){
        if(day == "Friday"){
            return 0;
        }else if(day == "Saturday"){
            return 1;
        }else if(day == "Sunday"){
            return 2;
        }
    }

    let studentPrices = [8.45, 9.8, 10.46];
    let businessPrices = [10.9, 15.6, 16];
    let regularPrices = [15, 20, 22.5];
    let dayIndex = getDayIndex(dayOfWeek);
    let price = 0;
    switch(groupType){
        case "Students": price += studentPrices[dayIndex]; break;
        case "Business": price += businessPrices[dayIndex]; break; 
        case "Regular": price += regularPrices[dayIndex]; break;
    }

    price *= groupSize;

    if(groupType == "Students" && groupSize >= 30){
        price *= 0.85;
    }else if(groupType == "Business" && groupSize >= 100){
        price -= (price / groupSize * 10);
    }else if(groupType == "Regular" && groupSize >= 10 && groupSize <= 20){
        price *= 0.95;
    }

    console.log(`Total price: ${price.toFixed(2)}`);
}

printTotal(30,"Students","Sunday");
printTotal(40, "Regular","Saturday");