function workingHours(input){
    let hour = Number(input[0]);
    let day = String(input[1]);
    let answer;

    switch(day){
        case "Monday":
        case "Tuesday":
        case "Wednesday":
        case "Thursday":
        case "Friday":
        case "Saturday":
            if(hour >= 10 && hour <= 18){
                answer = "open";
            }else{
                answer = "closed";
            }
            break;
        default:
            answer = "closed"
            break;
    }
    console.log(answer);
}
workingHours(["11",
"Sunday"]);
