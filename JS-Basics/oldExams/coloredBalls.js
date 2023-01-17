function coloredBalls(input){

    let totalPoints = 0;

    let redCount = 0;
    let orangeCount = 0;
    let yellowCount = 0;
    let whiteCount = 0;
    let blackCount = 0;
    let othersCount = 0;
    
    input.shift();

    let i = 0;
    while(i < input.length){
        switch(input[i]){
            case "red":
                totalPoints += 5;
                redCount++;
                break;
            case "orange":
                totalPoints += 10;
                orangeCount++;
                break;
            case "yellow":
                totalPoints += 15;
                yellowCount++;
                break;
            case "white":
                totalPoints += 20;
                whiteCount++;
                break;
            case "black":
                totalPoints = Math.floor(totalPoints/2);
                blackCount++;
                break;
            default:
                othersCount++;
                break;
        }
        i++;
    }

    console.log(`Total points: ${totalPoints}`);
    console.log(`Red balls: ${redCount}`);
    console.log(`Orange balls: ${orangeCount}`);
    console.log(`Yellow balls: ${yellowCount}`);
    console.log(`White balls: ${whiteCount}`);
    console.log(`Other colors picked: ${othersCount}`);
    console.log(`Divides from black balls: ${blackCount}`);

}

coloredBalls(["5",
"red",
"red",
"ddd",
"ddd",
"ddd"])
;