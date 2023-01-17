function poolDay(input){

    let numOfPeople = Number(input[0]);
    let entranceTax = Number(input[1]);
    let bedPrice = Number(input[2]);
    let umbrellaPrice = Number(input[3]);

    let numOfBeds = Math.ceil(numOfPeople*0.75);
    let numOfUmbrellas = Math.ceil(numOfPeople/2);

    let totalPrice = numOfPeople*entranceTax + numOfBeds*bedPrice + numOfUmbrellas*umbrellaPrice;

    console.log(`${totalPrice.toFixed(2)} lv.`);
}

poolDay(["50",
"6",
"8",
"4"])
;