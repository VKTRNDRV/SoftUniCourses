function examPrep(input){

    let tooManyFails = Number(input[0]);

    input.shift();

    let gradesSum = 0;
    let averageGrade;
    let gradesCount = 0;
    let failsCount = 0;
    let lastProblemName;

    let index = 0;
    while(index < input.length){
        if(input[index] == "Enough"){
            break;
        }

        lastProblemName = input[index];

        if(Number(input[index+1]) <= 4){
            failsCount++;
        }

        if(failsCount >= tooManyFails){
            console.log(`You need a break, ${failsCount} poor grades.`);
            break;
        }

        gradesSum += Number(input[index+1]);
        gradesCount++;

        index += 2;
    }

    if(failsCount < tooManyFails){
        averageGrade = gradesSum / gradesCount;

        console.log(`Average score: ${averageGrade.toFixed(2)}`);
        console.log(`Number of problems: ${gradesCount}`);
        console.log(`Last problem: ${lastProblemName}`);
    }

}

examPrep(["2",
"Income",
"3",
"Game Info",
"6",
"Best Player",
"4"])
;