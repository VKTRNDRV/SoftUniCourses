function exam(input){

    let numOfStudents = Number(input[0]);
    input.shift();

    let twosCount = 0;
    let threesCount = 0;
    let foursCount = 0;
    let fivesCount = 0;

    let sumAllGrades = 0;

    let i = 0;
    while(i < input.length){
        let currentGrade = Number(input[i]);

        if(currentGrade >= 2 && currentGrade < 3){
            twosCount++;
            sumAllGrades+= currentGrade;

        }else if(currentGrade >= 3 && currentGrade < 4){
            threesCount++;
            sumAllGrades+= currentGrade;

        }else if(currentGrade >= 4 && currentGrade < 5){
            foursCount++;
            sumAllGrades+= currentGrade;

        }else if(currentGrade >= 5){
            fivesCount++;
            sumAllGrades+= currentGrade;

        }

        i++;
    }
    
    let twosPercent = (twosCount / numOfStudents) * 100;
    let threesPercent = (threesCount / numOfStudents) * 100;
    let foursPercent = (foursCount / numOfStudents) * 100;
    let fivesPercent = (fivesCount / numOfStudents) * 100;

    console.log(`Top students: ${fivesPercent.toFixed(2)}%`);
    console.log(`Between 4.00 and 4.99: ${foursPercent.toFixed(2)}%`);
    console.log(`Between 3.00 and 3.99: ${threesPercent.toFixed(2)}%`);
    console.log(`Fail: ${twosPercent.toFixed(2)}%`);
    console.log(`Average: ${(sumAllGrades/numOfStudents).toFixed(2)}`);
}

exam(["6",
"2",
"3",
"4","5",
"6",
"2.2"])
;