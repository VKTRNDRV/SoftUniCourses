function clubRevenue(input){

    let targetRevenue = Number(input[0]);
    input.shift();
    let totalRevenue = 0;
    
    let i = 0;
    while(i < input.length){
        if(input[i] == "Party!"){
            break;
        }
        let currentDrinkPrice = input[i].length;
        let currentNumOfDrinksOrdered = Number(input[i+1]);
        let currentOrderPrice = 0;

        currentOrderPrice = currentNumOfDrinksOrdered * currentDrinkPrice;

        if(currentOrderPrice % 2 == 1){
            currentOrderPrice *= 0.75;
        }

        totalRevenue += currentOrderPrice;

        i+=2;
    }

    if(totalRevenue >= targetRevenue){
        console.log(`Target acquired.`);
        console.log(`Club income - ${totalRevenue.toFixed(2)} leva.`);

    }else{
        console.log(`We need ${(targetRevenue - totalRevenue).toFixed(2)} leva more.`);
        console.log(`Club income - ${totalRevenue.toFixed(2)} leva.`);
    }
}
clubRevenue(["100",
"Sidecar",
"7",
"Mojito",
"5",
"White Russian",
"10"]);
