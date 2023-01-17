function vowelsSum(input){
    let text = String(input[0]);
    let counter = 0;
    let char;

    for(let i = 0; i < text.length; i++){

        char = text[i];

        switch(char){
            case "a":
                counter += 1;
                break;
            case "e":
                counter += 2;
                break;
            case "i":
                counter += 3;
                break;
            case "o":
                counter += 4;
                break;
            case "u":
                counter += 5;
                break;
            default:
                break;
        }

    }
    console.log(counter);
}

vowelsSum(["beer"]);
