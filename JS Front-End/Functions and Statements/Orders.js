function calculateTotal(product, qty){
    let total = 0;
    switch(product){
        case "coffee": total = 1.5; break;
        case "water": total = 1; break;
        case "coke": total = 1.4; break;
        case "snacks": total = 2; break;
    }

    total *= qty;
    console.log(`${total.toFixed(2)}`);
}


calculateTotal("water", 5);
calculateTotal("coffee", 2);
calculateTotal("coke", 27364);