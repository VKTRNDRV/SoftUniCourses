function birthdayCake(input){

    let cakeX = Number(input[0]);
    let cakeY = Number(input[1]);

    let piecesLeft = cakeX*cakeY;

    input.shift();
    input.shift();

    index = 0;
    while(index < input.length){
        if(input[index] === "STOP"){
            break;
        }

        let piecesTaken = Number(input[index]);

        if(piecesTaken <= piecesLeft){
            piecesLeft -= piecesTaken;
        }
        
        if(piecesTaken > piecesLeft){
            piecesLeft -= piecesTaken;
        }
        index++;
    }

    if(piecesLeft >= 0){
        console.log(`${piecesLeft} pieces are left.`);

    }else{
        piecesLeft *= (-1);
        console.log(`No more cake left! You need ${piecesLeft} pieces more.`);

    }
}

birthdayCake(["10",
"2",
"2",
"4",
"6",
"STOP"])
;