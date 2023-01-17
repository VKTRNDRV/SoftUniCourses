function weekendOrWeekday(input){

    let inputString = String(input[0]);

    let result;

    switch(inputString){
        case "Monday":
            result = "Working day";
            break;
        case "Tuesday":
            result = "Working day";
            break;
        case "Wednesday":
            result = "Working day";
            break;
        case "Thursday":
            result = "Working day";
            break;
        case "Friday":
            result = "Working day";
            break;
        case "Saturday":
            result = "Weekend";
            break;
        case "Sunday":
            result = "Weekend";
            break;
        default:
            result = "Error";
            break;
    }

    console.log(result);

}