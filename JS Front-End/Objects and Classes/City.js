function printProperties(city){
    let properties = Object.entries(city);
    for(let entry of properties){
        console.log(`${entry[0]} -> ${entry[1]}`);
    }
}


let obj = {
    name: "Sofia",
    area: 492,
    population: 1238438,
    country: "Bulgaria",
    postCode: "1000"
}
printProperties(obj);
