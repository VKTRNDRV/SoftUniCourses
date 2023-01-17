function fruitShop(input){

    let fruit = String(input[0]);
    let dayOfTheWeek = String(input[1]);
    let qty = Number(input[2]);
    let priceForOne;
    let totalPrice;
    let isError;

    switch(dayOfTheWeek){
        case "Monday":
        case "Tuesday":
        case "Wednesday":
        case "Thursday":
        case "Friday":
            if(fruit == "banana"){
                priceForOne = 2.5;

            }else if(fruit == "apple"){
                priceForOne = 1.2;
                
            }else if(fruit == "orange"){
                priceForOne = 0.85;
                
            }else if(fruit == "grapefruit"){
                priceForOne = 1.45;
                
            }else if(fruit == "kiwi"){
                priceForOne = 2.7;
                
            }else if(fruit == "pineapple"){
                priceForOne = 5.5;
                
            }else if(fruit == "grapes"){
                priceForOne = 3.85;
                
            }else{
                isError = "error";
            }
            break;
        case "Saturday":
        case "Sunday":
            if(fruit == "banana"){
                priceForOne = 2.7;

            }else if(fruit == "apple"){
                priceForOne = 1.25;
                
            }else if(fruit == "orange"){
                priceForOne = 0.9;
                
            }else if(fruit == "grapefruit"){
                priceForOne = 1.6;
                
            }else if(fruit == "kiwi"){
                priceForOne = 3;
                
            }else if(fruit == "pineapple"){
                priceForOne = 5.6;
                
            }else if(fruit == "grapes"){
                priceForOne = 4.2;
                
            }else{
                isError = "error";
            }
            break;
        default:
            isError = "error";
            break;
    }

    totalPrice = priceForOne * qty;

    totalPrice = totalPrice.toFixed(2);

    if(isError == "error"){
        console.log(isError);
    }else{
        console.log(totalPrice)
    }
     
}

fruitShop(["tomato",
"Monday",
"0.5"]);