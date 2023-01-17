function cinemaTickets(input){

    let movieName = "";
    let freeSeats = 0;
    let ticketsCount = 0;

    let totalTickets = 0;
    let totalStudentTickets = 0;
    let totalStandardTickets = 0;
    let totalKidTickets = 0;

    let i = 0;
    while(i < input.length){
        if(i == 0){
            movieName = input[i];
            freeSeats = Number(input[i+1]);
            ticketsCount = 0;
            i += 2;
        }
        switch(input[i]){
            case "student":
                ticketsCount++;
                totalTickets++;
                totalStudentTickets++;
                i++;
                break;
            case "standard":
                ticketsCount++;
                totalTickets++;
                totalStandardTickets++;
                i++;
                break;
            case "kid":
                ticketsCount++;
                totalTickets++;
                totalKidTickets++;
                i++;
                break;
            default:
                break;
        }

        if(input[i] == "End"){
            console.log(`${movieName} - ${((ticketsCount/freeSeats)*100).toFixed(2)}% full.`);
            movieName = input[i+1];
            freeSeats = Number(input[i+2]);
            ticketsCount = 0;
            i+=3;
        }
        if(input[i] == "Finish"){
            console.log(`${movieName} - ${((ticketsCount/freeSeats)*100).toFixed(2)}% full.`);
            break;
        }

    }
    console.log(`Total tickets: ${totalTickets}`);
    console.log(`${(((totalStudentTickets/totalTickets)*100)).toFixed(2)}% student tickets.`);
    console.log(`${(((totalStandardTickets/totalTickets)*100)).toFixed(2)}% standard tickets.`);
    console.log(`${(((totalKidTickets/totalTickets)*100)).toFixed(2)}% kids tickets.`);
}

cinemaTickets(["The Matrix",
"20",
"student",
"standard",
"kid",
"kid",
"student",
"student",
"standard",
"student",
"End",
"The Green Mile",
"17",
"student",
"standard",
"standard",
"student",
"standard",
"student",
"End",
"Amadeus",
"3",
"standard",
"standard",
"standard",
"Finish"])
;