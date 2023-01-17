function happyCatParking(input){

    let totalDays = Number(input[0]);
    let totalHours = Number(input[1]);

    let defaultPrice = 1;
    let evenDayUnevenHourPrice = 2.5;
    let unevenDayEvenHourPrice = 1.25;

    let currentDayPrice = 0;
    let totalPrice = 0;

    let d = 1;
    while(d <= totalDays){

        let h = 1;
        while(h <= totalHours){

            if(d%2 == 1){
                if(h%2 == 1){
                    currentDayPrice += defaultPrice;
                    totalPrice += defaultPrice
                }else{
                    currentDayPrice += unevenDayEvenHourPrice;
                    totalPrice += unevenDayEvenHourPrice;
                }
            }else{
                if(h%2 == 1){
                    currentDayPrice += evenDayUnevenHourPrice;
                    totalPrice += evenDayUnevenHourPrice;
                }else{
                    currentDayPrice += defaultPrice;
                    totalPrice += defaultPrice
                }
            }
            if(h == totalHours){
                console.log(`Day: ${d} - ${currentDayPrice.toFixed(2)} leva`);
                currentDayPrice = 0;
            }
            h++;
        }
        d++;
    }
    console.log(`Total: ${totalPrice.toFixed(2)} leva`);
}

happyCatParking(["5","2"]);