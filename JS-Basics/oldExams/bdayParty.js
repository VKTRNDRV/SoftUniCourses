function bdayParty(input){

    let hallRent = Number(input);

    let cakePrice = hallRent * 0.2;
    let drinksPrice = cakePrice * 0.55;
    let entertainerPrice = hallRent * (1/3);

    let budget = hallRent + cakePrice + drinksPrice + entertainerPrice;

    console.log(budget);
}

bdayParty(["2"]);