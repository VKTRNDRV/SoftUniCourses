function dayOfWeek(input){
    
    let numInput = Number(input[0]);

    let outputDay;

    switch(numInput){
        case numInput = 1:
            outputDay = "Monday";
            break;
        case 2:
            outputDay = "Tuesday";
            break;
        case 3:
            outputDay = "Wednesday";
            break;
        case 4:
            outputDay = "Thursday";
            break;
        case 5:
            outputDay = "Friday";
            break;
        case 6:
            outputDay = "Saturday";
            break;
        case 7:
            outputDay = "Sunday";
            break;
        default:
            outputDay = "Error";
            break;
    }

    console.log(outputDay);

}

dayOfWeek(["1"]);