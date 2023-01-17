function profitNotesCoins(input){

    let count1Lev = Number(input[0]);
    let count2Lev = Number(input[1]);
    let count5Lev = Number(input[2]);
    let sum = Number(input[3]);

    let l1 = 0;
    while(l1 <= count1Lev){

        let l2 = 0;
        while(l2 <= count2Lev){

            let l5 = 0;
            while(l5 <= count5Lev){

                if(l1*1 + l2*2 + l5*5 == sum){
                    console.log(`${l1} * 1 lv. + ${l2} * 2 lv. + ${l5} * 5 lv. = ${sum} lv.`);
                }

                l5++;
            }
            l2++;
        }
        l1++;
    }
}

profitNotesCoins(["5","3","1","7"]);