function animalType(input){

    let animal = String(input[0]);

    let result;

    switch(animal){

        case "dog":
            result = "mammal";
            break;
        case "snake":
        case "crocodile":
        case "tortoise":
            result = "reptile";
            break;
        default:
            result = "unknown";
            break;

    }

    console.log(result);

}

animalType(["dog"])