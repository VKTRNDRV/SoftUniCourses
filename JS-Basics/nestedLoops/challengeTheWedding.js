function challengeTheWedding(input){

    let numOfMen = Number(input[0]);
    let numOfWomen = Number(input[1]);
    let numOfTables = Number(input[2]);

    let tableCount = 0;

    let output = "";

    let m = 1;
    while(m <= numOfMen){

        let w = 1;
        while(w <= numOfWomen){

            output += `(${m} <-> ${w})` + " ";

            tableCount++;
            w++;
            if(tableCount == numOfTables){
                break;
            }
        }
        m++;
        if(tableCount == numOfTables){
            break;
        }
    }

    console.log(output);
}

challengeTheWedding(["5","8","40"]);