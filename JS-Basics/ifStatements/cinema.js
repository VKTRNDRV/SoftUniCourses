function cinema(input){
    let eventType = String(input[0]);
    let rowsTotal = Number(input[1]);
    let columnsTotal = Number(input[2]);
    let seatPrice;

    switch(eventType){
        case "Premiere":
            seatPrice = 12;
            break;
        case "Normal":
            seatPrice = 7.5;
            break;
        case "Discount":
            seatPrice = 5;
            break;
        default:
            break;
    }

    console.log((rowsTotal*columnsTotal*seatPrice).toFixed(2));

}

cinema(["Discount",
"12",
"30"])
;