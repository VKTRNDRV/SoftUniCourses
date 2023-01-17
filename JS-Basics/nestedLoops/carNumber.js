function carNumber(input){

    let startDigit = Number(input[0]);
    let endDigit = Number(input[1]);

    let output = "";

    let d1 = startDigit;
    while(d1 <= endDigit){

        let d2 = startDigit;
        while(d2 <= endDigit){

            let d3 = startDigit;
            while(d3 <= endDigit){

                let d4 = startDigit;
                while(d4 <= endDigit){
                    let currentNum = String(d1) + String(d2) + String(d3) + String(d4);

                    if((d1>d4) && (d1%2==0) && (d4%2==1) && ((d2+d3)%2==0)){
                        output += currentNum + " ";

                    }else if((d1>d4) && (d1%2==1) && (d4%2==0) && ((d2+d3)%2==0)){
                        output += currentNum + " ";

                    }            
                    d4++;
                }
                d3++;
            }
            d2++;
        }
        d1++;
    }
    console.log(output);
}

carNumber(["3","5"]);