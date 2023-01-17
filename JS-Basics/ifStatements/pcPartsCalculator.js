function pcPartsCalculator(input){

    let budget = Number(input[0]);

    let numOfGPUs = Number(input[1]);
    let numOfCPUs = Number(input[2]);
    let numOfRAMs = Number(input[3]);

    let priceOfGPU = 250;
    let priceOfCPU = (numOfGPUs * priceOfGPU) * 0.35;
    let priceofRAM = (numOfGPUs * priceOfGPU) * 0.1;

    let totalPrice = numOfGPUs * priceOfGPU +
                        numOfCPUs * priceOfCPU +
                        numOfRAMs * priceofRAM;

    if(numOfGPUs > numOfCPUs){
        totalPrice = totalPrice * 0.85;
    }
    
    let difference = budget - totalPrice;

    if(difference >= 0){
        console.log("You have " + difference.toFixed(2) + " leva left!");
    }else{
        difference = difference * (-1);

        console.log("Not enough money! You need " + difference.toFixed(2) + " leva more!");
    }
}
pcPartsCalculator(["920.45",
"3",
"1",
"1"])

;