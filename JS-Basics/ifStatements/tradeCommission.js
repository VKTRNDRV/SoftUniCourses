function tradeCommission(input){
    let location = String(input[0]);
    let tradeVolume = Number(input[1]);
    let commissionRate;
    let totalCommission;
    let isError;

    switch(location){
        case "Sofia":
            if(tradeVolume >= 0 && tradeVolume <= 500){
                commissionRate = 0.05;

            }else if(tradeVolume > 500 && tradeVolume <= 1000){
                commissionRate = 0.07;

            }else if(tradeVolume > 1000 && tradeVolume <= 10000){
                commissionRate = 0.08;

            }else if(tradeVolume > 10000){
                commissionRate = 0.12;

            }else{
                isError = "error";
            }
            break;
        case "Varna":
            if(tradeVolume >= 0 && tradeVolume <= 500){
                commissionRate = 0.045;

            }else if(tradeVolume > 500 && tradeVolume <= 1000){
                commissionRate = 0.075;

            }else if(tradeVolume > 1000 && tradeVolume <= 10000){
                commissionRate = 0.1;

            }else if(tradeVolume > 10000){
                commissionRate = 0.13;

            }else{
                isError = "error";
            }
            break;
        case "Plovdiv":
            if(tradeVolume >= 0 && tradeVolume <= 500){
                commissionRate = 0.055;

            }else if(tradeVolume > 500 && tradeVolume <= 1000){
                commissionRate = 0.08;

            }else if(tradeVolume > 1000 && tradeVolume <= 10000){
                commissionRate = 0.12;

            }else if(tradeVolume > 10000){
                commissionRate = 0.145;

            }else{
                isError = "error";
            }
            break;
        default:
            isError = "error";
            break;
    }

    totalCommission = (tradeVolume * commissionRate).toFixed(2);

    if(isError == "error"){
        console.log(isError);
    }else{
        console.log(totalCommission);
    }

}

tradeCommission(["Kaspichan",
"-50"]);