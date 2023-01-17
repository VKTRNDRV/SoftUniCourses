function trekkingMania(input){

    let numOfGroups = Number(input[0]);

    const groups = input;
    groups.shift();

    let totalParticpants = 0;

    let countMusala = 0;
    let countMonblan = 0;
    let countKili = 0;
    let countK2 = 0;
    let countEverest = 0;

    let percentMusala = 0;
    let percentMonblan = 0;
    let percentKili = 0;
    let percentK2 = 0;
    let percentEverest = 0;

    for(i = 0; i <= (groups.length-1); i++){

        let num = Number(groups[i]);
        totalParticpants += num;

        if(num <= 5){
            countMusala += num;

        }else if(num >= 6 && num <= 12){
            countMonblan += num;

        }else if(num >= 13 && num <= 25){
            countKili += num;
            
        }else if(num >= 26 && num <= 40){
            countK2 += num;
            
        }else if(num >= 41){
            countEverest += num;
            
        }
    }

    percentMusala = countMusala / totalParticpants;
    percentMonblan = countMonblan / totalParticpants;
    percentKili = countKili / totalParticpants; 
    percentK2 = countK2 / totalParticpants; 
    percentEverest = countEverest / totalParticpants; 

    console.log((percentMusala*100).toFixed(2) + "%");
    console.log((percentMonblan*100).toFixed(2) + "%");
    console.log((percentKili*100).toFixed(2) + "%");
    console.log((percentK2*100).toFixed(2) + "%");
    console.log((percentEverest*100).toFixed(2) + "%");
}

trekkingMania(["10",
"10",
"5",
"1",
"100",
"12",
"26",
"17",
"37",
"40",
"78"])
;
