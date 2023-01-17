function weddingSeats(input){
    
    let lastSector = String(input[0]);
    let numOfSectors = lastSector.charCodeAt(0) - 64;

    let rowsInSectorA = Number(input[1]);

    let numOfSeatsOddRows = Number(input[2]);
    let numOfSeatsEvenRows = numOfSeatsOddRows + 2;

    let totalSeats = 0;

    let currentSector = 1;
    while(currentSector <= numOfSectors){

        let currentRow = 1;
        while(currentRow <= (rowsInSectorA + currentSector - 1)){

            let currentSeat = 1;
            if(currentRow % 2 == 1){
                while(currentSeat <= numOfSeatsOddRows){
                    console.log(String.fromCharCode(currentSector+64) + currentRow + String.fromCharCode(currentSeat+96));
                    currentSeat++;
                    totalSeats++;
                }
            }
            if(currentRow % 2 == 0){
                while(currentSeat <= numOfSeatsEvenRows){
                    console.log(String.fromCharCode(currentSector+64) + currentRow + String.fromCharCode(currentSeat+96));
                    currentSeat++;
                    totalSeats++;
                }
            }
            currentRow++;
        }
        currentSector++;
    }
    console.log(totalSeats);
}

weddingSeats(["C","4","2"]);