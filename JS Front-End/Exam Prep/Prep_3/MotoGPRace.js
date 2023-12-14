function solve(input){
    let initialCount = Number(input.shift());
    let riders = [];

    // insert initial
    while(initialCount-- > 0){
        let currentRider = input.shift().split("|");
        let name = currentRider[0];
        let fuelCapacity = Number(currentRider[1]);
        let position = Number(currentRider[2]);

        riders.push({name, fuelCapacity, position});
    }

    // modify as per commands
    while(input.length > 0){
        let command = input.shift().split(" - ");
        if(command[0] === "Finish"){
            break;
        }

        let riderName = command[1];

        switch(command[0]){
            case "StopForFuel":
                for(let rider of riders){
                    if(rider.name === riderName){
                        if(rider.fuelCapacity > Number(command[2])){
                            console.log(`${riderName} does not need to stop for fuel!`)
                            continue;
                        }
        
                        let changedPosition = Number(command[3]);
                        rider.position = changedPosition;
                        console.log(`${riderName} stopped to refuel but lost his position, now he is ${changedPosition}.`);
                        break;
                    }
                }
                break;

            case "Overtaking":
                let secondRiderName = command[2];
                let firstRider;
                let secondRider;
                for(let rider of riders){
                    if(rider.name === riderName){
                        firstRider = rider;
                    }
                    if(rider.name === secondRiderName){
                        secondRider = rider;
                    }
                }

                if(firstRider.position < secondRider.position){
                    let secondRiderPosition = secondRider.position;
                    secondRider.position = firstRider.position;
                    firstRider.position = secondRiderPosition;
                    console.log(`${firstRider.name} overtook ${secondRider.name}!`);
                }
                break;

            case "EngineFail":
                for(let rider of riders){
                    if(rider.name === riderName){
                        riders.splice(riders.indexOf(rider), 1);
                        console.log(`${riderName} is out of the race because of a technical issue, ${command[2]} laps before the finish.`);
                        break;
                    }
                }
                break;
        }
    }

    // sort(?) and print
    for(let rider of riders){
        console.log(rider.name);
        console.log(`  Final position: ${rider.position}`);
    }
}

solve(["3",
"Valentino Rossi|100|1",
"Marc Marquez|90|2",
"Jorge Lorenzo|80|3",
"StopForFuel - Valentino Rossi - 50 - 1",
"Overtaking - Marc Marquez - Jorge Lorenzo",
"EngineFail - Marc Marquez - 10",
"Finish"]);

solve(["4",
"Valentino Rossi|100|1",
"Marc Marquez|90|3",
"Jorge Lorenzo|80|4",
"Johann Zarco|80|2",
"StopForFuel - Johann Zarco - 90 - 5",
"Overtaking - Marc Marquez - Jorge Lorenzo",
"EngineFail - Marc Marquez - 10",
"Finish"]);