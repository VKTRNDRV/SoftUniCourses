function smallShop(input){

    let product = String(input[0]);
    let city = String(input[1]);
    let qty = Number(input[2]);
    let pricePerItem;
    let totalPrice;
    
    switch(city){
        case city = "Sofia":
            switch(product){
                case "coffee":
                    pricePerItem = 0.5;
                    break;
                case "water":
                    pricePerItem = 0.8;
                    break;
                case "beer":
                    pricePerItem = 1.2;
                    break;
                case "sweets":
                    pricePerItem = 1.45;
                    break;
                case "peanuts":
                    pricePerItem = 1.6;
                    break;
                default:
                    break;
            }
            break;
        case city = "Plovdiv":
            switch(product){
                case "coffee":
                    pricePerItem = 0.4;
                    break;
                case "water":
                    pricePerItem = 0.7;
                    break;
                case "beer":
                    pricePerItem = 1.15;
                    break;
                case "sweets":
                    pricePerItem = 1.3;
                    break;
                case "peanuts":
                    pricePerItem = 1.5;
                    break;
                default:
                    break;
            }
            break;
        case city = "Varna":
            switch(product){
                case "coffee":
                    pricePerItem = 0.45;
                    break;
                case "water":
                    pricePerItem = 0.7;
                    break;
                case "beer":
                    pricePerItem = 1.1;
                    break;
                case "sweets":
                    pricePerItem = 1.35;
                    break;
                case "peanuts":
                    pricePerItem = 1.55;
                    break;
                default:
                    break;
            }
            break;
        default:
            break;
        
    }

    totalPrice = qty * pricePerItem;

    console.log(totalPrice);
}

smallShop(["sweets",
"Sofia",
"2.23"])
;