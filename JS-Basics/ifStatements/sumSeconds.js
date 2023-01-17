function sumSeconds(input){
    let time1 = Number(input[0]);
    let time2 = Number(input[1]);
    let time3 = Number(input[2]);

    let totalTimeSeconds = time1 + time2 + time3;

    let leftOverSeconds = totalTimeSeconds % 60;

    let totalTimeMins = Math.floor(totalTimeSeconds / 60);

    if(leftOverSeconds <= 9){
        console.log(totalTimeMins + ":0" + leftOverSeconds);
    }

    if(leftOverSeconds >= 10){
        console.log(totalTimeMins + ":" + leftOverSeconds);
    }


}

sumSeconds(["14","12","10"]);