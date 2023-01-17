function hairSalon(input){

    let targetRevenue = Number(input[0]);
    input.shift();

    let totalRevenue = 0;

    let i = 0;
    while(i < input.length){
        if(input[i] == "closed"){
            break;
        }
        let serviceType = String(input[i]);
        let serviceDetails = String(input[i+1]);

        let servicePrice = 0;
        switch(serviceType){

            case "haircut":
                switch (serviceDetails){
                    case "mens":
                        servicePrice = 15;
                        break;
                    case "ladies":
                        servicePrice = 20;
                        break;
                    case "kids":
                        servicePrice = 10;
                        break;
                    default:
                        break;
                }
                break;

            case "color":
                switch(serviceDetails){
                    case "touch up":
                        servicePrice = 20;
                        break;
                    case "full color":
                        servicePrice = 30;
                        break;
                    default:
                        break;
                }
                break;

            default:
                break;
        }

        totalRevenue += servicePrice;

        if(totalRevenue >= targetRevenue){
            break;
        }
        i+=2;
    }

    if(totalRevenue >= targetRevenue){
        console.log(`You have reached your target for the day!`);
        console.log(`Earned money: ${totalRevenue}lv.`);

    }else{
        console.log(`Target not reached! You need ${targetRevenue - totalRevenue}lv. more.`);
        console.log(`Earned money: ${totalRevenue}lv.`);
    }
}

hairSalon(["50",
"color",
"full color",
"haircut",
"ladies"])
;