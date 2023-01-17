function newHouse(input){
    let flowerType = String(input[0]);
    let qtyFlowers = Number(input[1]);
    let budget = Number(input[2]);

    let pricePerFlower;
    let priceAdjustment = 1;
    let totalPrice;
    let leftoverCash;

    switch(flowerType){ //calculating priceAdjustment
        case "Roses":
            if(qtyFlowers > 80){
                priceAdjustment = 1 - 0.1;
            }
            break;

        case "Dahlias":
            if(qtyFlowers > 90){
                priceAdjustment = 1 - 0.15;
            }
            break;

        case "Tulips":
            if(qtyFlowers > 80){
                priceAdjustment = 1 - 0.15;
            }
            break;

        case "Narcissus":
            if(qtyFlowers < 120){
                priceAdjustment = 1 + 0.15;
            }
            break;

        case "Gladiolus":
            if(qtyFlowers < 80){
                priceAdjustment = 1 + 0.2;
            }
            break;

        default:
            break;
    }

    switch(flowerType){ //calculating pricePerFlower
        case "Roses":
            pricePerFlower = 5;
            break;

        case "Dahlias":
            pricePerFlower = 3.8;
            break;

        case "Tulips":
            pricePerFlower = 2.8;
            break;

        case "Narcissus":
            pricePerFlower = 3;
            break;

        case "Gladiolus":
            pricePerFlower = 2.5;
            break;

        default:
            break;
    }

    totalPrice = (pricePerFlower * qtyFlowers) * priceAdjustment;
    leftoverCash = budget - totalPrice;

    if(leftoverCash >= 0){

        console.log("Hey, you have a great garden with " + qtyFlowers + " " + flowerType + " and " + leftoverCash.toFixed(2) + " leva left.")
        
    }else{
        leftoverCash = leftoverCash * (-1);

        console.log("Not enough money, you need " + leftoverCash.toFixed(2) + " leva more.")
    }

}

newHouse(["Tulips",
"88",
"260"])
;