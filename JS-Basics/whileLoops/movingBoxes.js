function movingBoxes(input){

    let roomX = Number(input[0]);
    let roomY = Number(input[1]);
    let roomZ = Number(input[2]);

    let maxBoxes = roomX*roomY*roomZ;

    let totalBoxes = 0;

    input.shift();
    input.shift();
    input.shift();


    index = 0;
    while(index < input.length){
        if(input[index] === "Done"){
            break;
        }
        if(totalBoxes >= maxBoxes){
            break;
        }

        totalBoxes += Number(input[index]);

        index++;
    }

    if(totalBoxes <= maxBoxes){
        console.log(`${maxBoxes - totalBoxes} Cubic meters left.`)
    }else{
        console.log(`No more free space! You need ${totalBoxes - maxBoxes} Cubic meters more.`)
    }
}

movingBoxes(["10", 
"1",
"2",
"4", 
"6",
"Done"])
;