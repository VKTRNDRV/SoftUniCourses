function journeyPlanner(input){

    let budget = Number(input[0]);
    let budgetSpent;
    let season = String(input[1]);
    let destination;
    let accommodationType;

    if(budget <= 100){ //calculating destination
        destination = "Bulgaria";

    }else if(budget > 100 && budget <= 1000){
        destination = "Balkans";

    }else if(budget > 1000){
        destination = "Europe";
    }

    switch(destination){ //calculating budgetSpent & accommodationType
        case "Bulgaria":
            switch(season){
                case "summer":
                    budgetSpent = budget * 0.3;
                    accommodationType = "Camp";
                    break;
                case "winter":
                    budgetSpent = budget * 0.7;
                    accommodationType = "Hotel";
                    break;
                default:
                    break;
            }
            break;
        case "Balkans":
            switch(season){
                case "summer":
                    budgetSpent = budget * 0.4;
                    accommodationType = "Camp";
                    break;
                case "winter":
                    budgetSpent = budget * 0.8;
                    accommodationType = "Hotel";
                    break;
                default:
                    break;
            }
            break;
        case "Europe":
            switch(season){
                case "summer":
                case "winter":
                    budgetSpent = budget * 0.9;
                    accommodationType = "Hotel";
                    break;
                default:
                    break;
            }
            break;
        default:
            break;
    }

    console.log("Somewhere in " + destination);
    console.log(accommodationType + " - " + budgetSpent.toFixed(2))

}

journeyPlanner(["50", "summer"]);