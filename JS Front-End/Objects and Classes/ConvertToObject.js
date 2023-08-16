function toObj(jsonStr){
    let obj = JSON.parse(jsonStr);
    for(let field of Object.entries(obj)){
        console.log(`${field[0]}: ${field[1]}`);
    }
}


toObj('{"name": "George", "age": 40, "town": "Sofia"}');
toObj('{"name": "Peter", "age": 35, "town": "Plovdiv"}');