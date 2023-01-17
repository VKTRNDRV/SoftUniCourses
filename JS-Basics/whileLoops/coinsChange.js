function coinsChange(input){

    let change = Number(input[0]);

    change = (change*100).toFixed();

    let coinCount = 0;

    while(change !=0){

        let coinsadded = 0;

        if(change >= 200){
           coinsadded = Math.floor(change/200);
           change = change % 200;
           coinCount += coinsadded;
        }

        if(change >= 100){
            coinsadded = Math.floor(change/100);
            change = change % 100;
            coinCount += coinsadded;
        }

        if(change >= 50){
            coinsadded = Math.floor(change/50);
            change = change % 50;
            coinCount += coinsadded;
        }

        if(change >= 20){
            coinsadded = Math.floor(change/20);
            change = change % 20;
            coinCount += coinsadded;
        }

        if(change >= 10){
            coinsadded = Math.floor(change/10);
            change = change % 10;
            coinCount += coinsadded;
        }

        if(change >= 5){
            coinsadded = Math.floor(change/5);
            change = change % 5;
            coinCount += coinsadded;
        }

        if(change >= 2){
            coinsadded = Math.floor(change/2);
            change = change % 2;
            coinCount += coinsadded;
        }

        if(change == 1){
            coinCount++;
            break;
        }
    }
    console.log(coinCount);
}

coinsChange(["0.43"]);