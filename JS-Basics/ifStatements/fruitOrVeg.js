function fruitOrVeg(input){
    let nameInput = String(input[0]);
    let answer;

    switch(nameInput){
        case "banana":
        case "apple":
        case "kiwi":
        case "cherry":
        case "lemon":
        case "grapes":
            answer = "fruit";
            break;
        case "tomato":
        case "cucumber":
        case "pepper":
        case "carrot":
            answer = "vegetable";
            break;
        default:
            answer = "unknown";
            break;
    }
    console.log(answer);
}