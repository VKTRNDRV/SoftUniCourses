function luckyNums(input){

    let num = Number(input[0]);

    let output = "";

    let d1 = 1;
    while(d1 <= 9){

        let d2 = 1;
        while(d2 <= 9){

            let d3 = 1;
            while(d3 <= 9){

                let d4 = 1;
                while(d4 <= 9){
                    let currentNum = String(d1)+String(d2)+String(d3)+String(d4);
                    
                    if((d1+d2==d3+d4) && (num % (d1+d2) == 0)){
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

luckyNums(["24"]);