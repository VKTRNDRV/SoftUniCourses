function parseTowns(info){
    for(cell of info){
        let townInfo = cell.split(/\s*\|\s*/);
        let town = {};
        town.town = townInfo[0];
        town.latitude = Number.parseFloat(townInfo[1]).toFixed(2);
        town.longitude = Number.parseFloat(townInfo[2]).toFixed(2);
        console.log(town);
    }
}



console.log(parseTowns(
    ['Sofia | 42.696552 | 23.32601',
'Beijing | 39.913818 | 116.363625']
));

// console.log(parseTowns(
//     ['Plovdiv | 136.45 | 812.575']
// ));