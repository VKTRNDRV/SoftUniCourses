function onTime(input){

    let examHour = Number(input[0]);
    let examMinute = Number(input[1]);

    let arrivalHour = Number(input[2]);
    let arrivalMinute = Number(input[3]);

    let arrivalCondition;

    let hourDifference = examHour - arrivalHour;
    let minuteDifference = examMinute - arrivalMinute;

    let minutesEarly = (hourDifference*60) + minuteDifference;

    let outputHour;
    let outputMinutes;
    let outputMinutesString;

    //calculating arrivalCondition
    if(minutesEarly > 30){ 
        arrivalCondition = "Early";

    }else if(minutesEarly <= 30 && minutesEarly >= 0){
        arrivalCondition = "On time";

    }else if(minutesEarly < 0){
        arrivalCondition = "Late";
    }

    //calculating hh:mm || mm WIP - MINUTES ALWAYS TWO DIGITS
    if(minutesEarly >= 60){  
        outputHour = Math.floor(minutesEarly / 60);
        outputMinutes = minutesEarly % 60;

        if(outputMinutes < 10){
            outputMinutesString = ("0" + outputMinutes);
        }else{
            outputMinutesString = String(outputMinutes);
        }

    }else if(minutesEarly < 60 && minutesEarly > 0){
        outputMinutes = minutesEarly;

        if(outputMinutes < 10){
            outputMinutesString = ("0" + outputMinutes);
        }else{
            outputMinutesString = String(outputMinutes);
        }

    }else if(minutesEarly === 0){
        //do nothing, arrivalCondition should already be set to "On time"

    }else if(minutesEarly < 0 && minutesEarly > (-60)){
        outputMinutes = minutesEarly*(-1);

        if(outputMinutes < 10){
            outputMinutesString = ("0" + outputMinutes);
        }else{
            outputMinutesString = String(outputMinutes);
        }

    }else if(minutesEarly <= (-60)){
        outputHour = Math.floor((minutesEarly*(-1)) / 60);
        outputMinutes = (minutesEarly*(-1)) % 60;

        if(outputMinutes < 10){
            outputMinutesString = ("0" + outputMinutes);
        }else{
            outputMinutesString = String(outputMinutes);
        }
    }

    //calculating output - FINISH ON TIME
    switch(arrivalCondition){ 
        case "Early":
            if(minutesEarly >= 60){
                console.log(arrivalCondition);
                console.log(`${outputHour}:${outputMinutesString} hours before the start`);

            }else if(minutesEarly < 60){
                console.log(arrivalCondition);
                console.log(`${outputMinutes} minutes before the start`);
            }
            break;

        case "On time":
            if(minutesEarly > 0){
                console.log(arrivalCondition);
                console.log(`${outputMinutes} minutes before the start`);

            }else if(minutesEarly === 0){
                console.log(arrivalCondition);
            }
            break;

        case "Late":
            if(minutesEarly < 0 && minutesEarly > (-60)){
                console.log(arrivalCondition);
                console.log(`${outputMinutes} minutes after the start`);
            }else if(minutesEarly <= (-60)){
                console.log(arrivalCondition);
                console.log(`${outputHour}:${outputMinutesString} hours after the start`);
            }
            break;

        default:
             break;
    }   
}

onTime(["14",
"00",
"13",
"55"])
;