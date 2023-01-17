function suitcasesLoad(input){

    let trunkCapacity = Number(input[0]);
    input.shift();

    let spaceTaken = 0;
    let suitcasesLoaded = 0;

    let isNotEnoughSpace = false;

    let i = 0;
    while(input[i] != "End" && i < input.length){

        if((i+1) % 3 != 0){        

            if(spaceTaken + Number(input[i]) <= trunkCapacity){
                spaceTaken += Number(input[i]);
                suitcasesLoaded++;
            }else{
                isNotEnoughSpace = true;
                break;
            }
        }else{

            if((spaceTaken + (Number(input[i]*1.1))) <= trunkCapacity){
                spaceTaken += Number(input[i]*1.1);
                suitcasesLoaded++;
            }else{
                isNotEnoughSpace = true;
                break;
            }
        }
        i++;
    }

    if(isNotEnoughSpace == false){
        console.log(`Congratulations! All suitcases are loaded!`);
        console.log(`Statistic: ${suitcasesLoaded} suitcases loaded.`);
    }else{
        console.log(`No more space!`);
        console.log(`Statistic: ${suitcasesLoaded} suitcases loaded.`);
    }
}

suitcasesLoad(["1200.2",
"2600",
"380.5",
"125.6",
"305",
"End"]);