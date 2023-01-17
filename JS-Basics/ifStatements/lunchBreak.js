function lunchBreak(input){

    let showName = String(input[0]);

    let episodeLength = Number(input[1]);
    let breakLength = Number(input[2]);

    let lunchLength = breakLength / 8;
    let relaxLength = breakLength / 4;

    let freeTime = breakLength - (lunchLength + relaxLength + episodeLength);

    if(freeTime >= 0){

        console.log("You have enough time to watch " + showName + " and left with " + Math.ceil(freeTime) + " minutes free time.")
    
    }else{

        freeTime = freeTime * (-1);
        console.log("You don't have enough time to watch " + showName + ", you need " + Math.ceil(freeTime) + " more minutes.")

    }

}

lunchBreak(["Teen Wolf",
"48",
"60"])
;