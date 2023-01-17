function graduationCalculator(input){

    let name = String(input[0]);

    input.shift();

    let sumAllGrades = 0;
    let averageGrade;

    let index = 0;
    let failGrades = 0;
    while(index < input.length){

        if(Number(input[index]) < 4){
            failGrades++;
        }

        if(failGrades >= 2){
            console.log(`${name} has been excluded at ${index} grade`);
            break;
        }

        sumAllGrades += Number(input[index]);

        index++;
    }

    if(failGrades < 2){

        averageGrade = sumAllGrades / input.length;
        console.log(`${name} graduated. Average grade: ${averageGrade.toFixed(2)}`);
    }
}

graduationCalculator(["Mimi", 
"5",
"6",
"5",
"6",
"5",
"6",
"6",
"2",
"3"])
;