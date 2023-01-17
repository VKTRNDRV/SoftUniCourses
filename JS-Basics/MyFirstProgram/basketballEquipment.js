function basketballEquipment(input){
    let yearlyPricePractice = Number(input);

    let shoesPrice = yearlyPricePractice * 0.6;
    let jerseyPrice = shoesPrice * 0.8;
    let ballPrice = jerseyPrice * 0.25;
    let accessoriesPrice = ballPrice * 0.2;

    let sumPrice = yearlyPricePractice + shoesPrice + jerseyPrice + ballPrice + accessoriesPrice;

    console.log(sumPrice);

}

basketballEquipment("365");