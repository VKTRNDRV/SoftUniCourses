function courierExpress(input){

    let packageWeightKG = Number(input[0]);
    let serviceType = String(input[1]);
    let distanceKM = Number(input[2]);
    let totalPrice = 0;

    let pricePerKM = 0;
    if(packageWeightKG < 1){
        pricePerKM = 0.03;

    }else if(packageWeightKG >= 1 && packageWeightKG < 10){
        pricePerKM = 0.05;

    }else if(packageWeightKG >= 10 && packageWeightKG < 40){
        pricePerKM = 0.1;

    }else if(packageWeightKG >= 40 && packageWeightKG < 90){
        pricePerKM = 0.15;

    }else if(packageWeightKG >= 90 && packageWeightKG < 150){
        pricePerKM = 0.2;
    }

    let expressPriceAdjustment = 1;
    if(serviceType === "express"){
        if(packageWeightKG < 1){
            expressPriceAdjustment += 0.8;
    
        }else if(packageWeightKG >= 1 && packageWeightKG < 10){
            expressPriceAdjustment += 0.4;
    
        }else if(packageWeightKG >= 10 && packageWeightKG < 40){
            expressPriceAdjustment += 0.05;
    
        }else if(packageWeightKG >= 40 && packageWeightKG < 90){
            expressPriceAdjustment += 0.02;
    
        }else if(packageWeightKG >= 90 && packageWeightKG < 150){
            expressPriceAdjustment += 0.01;
        }
    }

    totalPrice = distanceKM * pricePerKM;

    if(serviceType === "express"){
        let extra = pricePerKM*(expressPriceAdjustment-1);
        extra = extra * packageWeightKG;
        extra = extra * distanceKM;
        totalPrice += extra;
    }

    console.log(`The delivery of your shipment with weight of ${packageWeightKG.toFixed(3)} kg. would cost ${totalPrice.toFixed(2)} lv.`);

}

courierExpress(["20",
"standard",
"349"])
;