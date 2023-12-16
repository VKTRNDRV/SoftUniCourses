function solve(input){
    let count = Number(input.shift());
    let baristas = [];

    function getBaristaByName(baristaName){
        for(let barista of baristas){
            if(barista.name == baristaName){
                return barista;
            }
        }
    }

    function baristaKnowsCoffeType(barista, coffeeType){
        for(let currentCoffeeType of barista.coffeeTypes){
            if(currentCoffeeType == coffeeType){
                return true;
            }
        }

        return false;
    }

    // add initial
    while(count-- > 0){
        let [baristaName, baristaShift, types] = input
        .shift().split(" ");

        baristas.push({
            name: baristaName,
            shift: baristaShift,
            coffeeTypes: types.split(",")
        })
    }

    // execute commands
    while(input.length > 0){
        let line = input.shift();
        if(line === "Closed"){
            break;
        }

        let command = line.split(" / ");
        let barista = getBaristaByName(command[1]);

        switch(command[0]){
            case "Prepare":
                let shift = command[2];
                let reqCoffeeType = command[3];
                if(barista.shift != shift || !baristaKnowsCoffeType(barista, reqCoffeeType)){
                    console.log(`${barista.name} is not available to prepare a ${reqCoffeeType}.`);
                    continue;
                }

                console.log(`${barista.name} has prepared a ${reqCoffeeType} for you!`);
                break;

            case "Change Shift":
                let shiftNew = command[2];
                barista.shift = shiftNew;
                console.log(`${barista.name} has updated his shift to: ${barista.shift}`);
                break;

            case "Learn":
                let coffeeTypeNew = command[2];
                if(baristaKnowsCoffeType(barista, coffeeTypeNew)){
                    console.log(`${barista.name} knows how to make ${coffeeTypeNew}.`);
                    continue;
                }

                barista.coffeeTypes.push(coffeeTypeNew);
                console.log(`${barista.name} has learned a new coffee type: ${coffeeTypeNew}.`);
                break;
        }
    }

    //print results
    for(let barista of baristas){
        console.log(`Barista: ${barista.name}, Shift: ${barista.shift}, Drinks: ${barista.coffeeTypes.join(", ")}`);
    }
}

solve([
    '3',
      'Alice day Espresso,Cappuccino',
      'Bob night Latte,Mocha',
      'Carol day Americano,Mocha',
      'Prepare / Alice / day / Espresso',
      'Change Shift / Bob / night',
      'Learn / Carol / Latte',
      'Learn / Bob / Latte',
      'Prepare / Bob / night / Latte',
      'Closed']);

console.log("==================================================================")

solve(['4',
'Alice day Espresso,Cappuccino',
'Bob night Latte,Mocha',
'Carol day Americano,Mocha',
'David night Espresso',
'Prepare / Alice / day / Espresso',
'Change Shift / Bob / day',
'Learn / Carol / Latte',
'Prepare / Bob / night / Latte',
'Learn / David / Cappuccino',
'Prepare / Carol / day / Cappuccino',
'Change Shift / Alice / night',
 'Learn / Bob / Mocha',
'Prepare / David / night / Espresso',
'Closed']);