function summerOutfit(input){

    let tempDegrees = Number(input[0]);
    let timeOfDay = String(input[1]);
    let outfit;
    let shoes;

        if(tempDegrees >= 10 && tempDegrees <= 18){
            switch(timeOfDay){
                case "Morning":
                    outfit = "Sweatshirt";
                    shoes = "Sneakers";
                    break;

                case "Afternoon":
                    outfit = "Shirt";
                    shoes = "Moccasins";
                    break;

                case "Evening":
                    outfit = "Shirt";
                    shoes = "Moccasins";
                    break;

                default:
                    break;
            }
        }
        if(tempDegrees > 18 && tempDegrees <= 24){
            switch(timeOfDay){
                case "Morning":
                    outfit = "Shirt";
                    shoes = "Moccasins";
                    break;

                case "Afternoon":
                    outfit = "T-Shirt";
                    shoes = "Sandals";
                    break;

                case "Evening":
                    outfit = "Shirt";
                    shoes = "Moccasins";
                    break;
                    
                default:
                    break;
            }
        }
        if(tempDegrees >= 25){
            switch(timeOfDay){
                case "Morning":
                    outfit = "T-Shirt";
                    shoes = "Sandals";
                    break;

                case "Afternoon":
                    outfit = "Swim Suit";
                    shoes = "Barefoot";
                    break;

                case "Evening":
                    outfit = "Shirt";
                    shoes = "Moccasins";
                    break;
                    
                default:
                    break;
            }
        }

    console.log("It's " + tempDegrees + " degrees, get your " + outfit + " and " + shoes + ".");

}

summerOutfit(["28",
"Evening"])
;