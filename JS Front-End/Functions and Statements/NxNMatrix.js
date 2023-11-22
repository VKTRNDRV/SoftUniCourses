function printMatrixOfSize(size){
    let row = ` ${size.toString()}`.repeat(size);
    for(let i = 0; i < size; i++){
        console.log(row);
    }
}

printMatrixOfSize(3);
printMatrixOfSize(7);
printMatrixOfSize(2);
printMatrixOfSize(39);