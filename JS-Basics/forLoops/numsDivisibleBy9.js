function numsDivisibleBy9(input){
    let num1 = Number(input[0]);
    let num2 = Number(input[1]);
    let answersIndex = 0;
    const answers = [];
    let sum = 0;

    //calculating sum && noting down answes in answers[]
    for(let i = num1; i <= num2; i++){
        if(i % 9 === 0){
            sum = sum + i;
            answers[answersIndex] = i;
            answersIndex++
        }
    }
    //printing out sum
    console.log(`The sum: ${sum}`);

    //printing out answers
    for(let i = 0; i < answers.length; i++){
        console.log(answers[i]);
    }
}

numsDivisibleBy9(["100", "200"]);