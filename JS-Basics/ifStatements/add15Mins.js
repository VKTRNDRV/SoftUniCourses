function add15Mins(input){
    let hour = Number(input[0]);
    let mins = parseInt(input[1]);

    if(mins < 45){
        mins = mins + 15;

    }else if(mins >= 45){
        if(hour == 23){
            hour = 0;
            mins = mins - 45;
        }else{
            hour++;
            mins = mins - 45;
        }

    }
    let minsText = mins.toString();
    if(mins <= 9){
        minsText = "0" + minsText;
    }

    console.log(hour + ":" + minsText);
}

add15Mins(["12", "49"]);