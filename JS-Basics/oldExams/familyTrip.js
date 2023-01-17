function familyTrip(input){

    let totalBudget = Number(input[0]);
    let nightsBooked = Number(input[1]);
    let nightPrice = Number(input[2]);
    let percentRecreation = Number(input[3]) / 100;
    let recreationExpenses = totalBudget * percentRecreation;

    let hotelExpenses = 0;
    if(nightsBooked <= 7){
        hotelExpenses = nightsBooked * nightPrice;
    }else{
        hotelExpenses = nightsBooked * (nightPrice*0.95);
    }

    let totalExpenses = hotelExpenses + recreationExpenses;

    if(totalExpenses <= totalBudget){
        console.log(`Ivanovi will be left with ${(totalBudget - totalExpenses).toFixed(2)} leva after vacation.`);
    }else{
        console.log(`${(totalExpenses - totalBudget).toFixed(2)} leva needed.`);
    }
}

familyTrip(["500",
"7",
"66",
"15"])
;