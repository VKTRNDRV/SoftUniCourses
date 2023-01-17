function multiplyTable(input){

    let inputNum = String(input[0]);

    let firstDigit = Number(inputNum.charAt(0));
    let secondDigit = Number(inputNum.charAt(1));
    let thirdDigit = Number(inputNum.charAt(2));

    let maxFirstNumCalc = thirdDigit;
    let maxSecondNumCalc = secondDigit;
    let maxThirdNumCalc = firstDigit;

    let n1 = 1;
    while(n1 <= maxFirstNumCalc){
        let n2 = 1;
        while(n2 <= maxSecondNumCalc){
            let n3 = 1;
            while(n3 <= maxThirdNumCalc){

                console.log(`${n1} * ${n2} * ${n3} = ${n1*n2*n3};`);
             
                n3++;
            }
            n2++;
        }
        n1++;
    }
}

multiplyTable(["222"]);