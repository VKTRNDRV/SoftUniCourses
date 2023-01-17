function bestPlayer(input){

    let bestName = "";
    let bestGoals = 0;
    let isHattrick = false;
    
    let i = 0
    while(i < input.length){
        let currentName = input[i];
        let numOfGoals = Number(input[i+1]);

        if(input[i] == "END"){break;}
        if(bestGoals >= 10){break;}

        if(numOfGoals > bestGoals){
            bestName = currentName;
            bestGoals = numOfGoals

            if(numOfGoals >= 3){
                isHattrick = true;
            }else{
                isHattrick - false;
            }
        }

        i+=2;
    }

    if(isHattrick == true){
        console.log(`${bestName} is the best player!`);
        console.log(`He has scored ${bestGoals} goals and made a hat-trick !!!`)
    }else{
        console.log(`${bestName} is the best player!`);
        console.log(`He has scored ${bestGoals} goals.`)
    }
}

bestPlayer(["Zidane",
"1",
"Felipe",
"2",
"Johnson",
"4",
"END"]);