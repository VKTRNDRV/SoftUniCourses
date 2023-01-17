function agencyProfit(input){

    let name = String(input[0]);
    let totalAdultTickets = Number(input[1]);
    let totalKidsTickets = Number(input[2]);
    
    let adultTicketPrice = Number(input[3]);
    let kidTicketPrice = adultTicketPrice * 0.3;

    let serviceTax = Number(input[4]);

    let totalProfit = (((totalAdultTickets*adultTicketPrice + totalAdultTickets*serviceTax)+(totalKidsTickets*kidTicketPrice + totalKidsTickets*serviceTax))*0.2).toFixed(2)

    console.log(`The profit of your agency from ${name} tickets is ${totalProfit} lv.`)
}

agencyProfit(["WizzAir","15","5","120","40"]);