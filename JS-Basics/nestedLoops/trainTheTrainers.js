function trainTheTrainers(input){
    
    let numOfJudges = Number(input[0]);
    let numOfProjects = 0;
    let sumAllGrades = 0;

    let projectName = "";

    const info = input;
    info.shift();

    let i = 0
    while(i < info.length){
        let projectGrade = 0;



        if(isNaN(info[i]) == true){
            if(info[i] == "Finish"){
                console.log(`Student's final assessment is ${(sumAllGrades / (numOfJudges*numOfProjects)).toFixed(2)}.`)
                break;
            }
            projectName = info[i];
            numOfProjects++;
            projectGrade = 0;
            i++;
        }

        while(isNaN(info[i]) == false){
            projectGrade += Number(info[i]);
            sumAllGrades += Number(info[i]);
            i++;
        }

        if(isNaN(info[i]) == true){
            projectGrade = projectGrade / numOfJudges;
            console.log(`${projectName} - ${projectGrade.toFixed(2)}.`);
        }
    }
}

trainTheTrainers(["2",
"Objects and Classes",
"5.77",
"4.23",
"Dictionaries",
"4.62",
"5.02",
"RegEx",
"2.88",
"3.42",
"Finish"])
;