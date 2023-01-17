function foodDelivery(input){
    let qtyChickenMenu = Number(input[0]);
    let qtyFishMenu = Number(input[1]);
    let qtyVegMenu = Number(input[2]);

    let priceChickenMenu = 10.35;
    let priceFishMenu = 12.40;
    let priceVegMenu = 8.15;
    let priceDelivery = 2.50;

    let noDessertSum = qtyChickenMenu*priceChickenMenu + qtyFishMenu*priceFishMenu + qtyVegMenu*priceVegMenu;
    let includedDessertSum = noDessertSum*1.2

    let totalSum = includedDessertSum + priceDelivery;

    console.log(totalSum);
}

foodDelivery(["2","4","3"]);