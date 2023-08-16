function toJson(name, lastName, hairColor){
    obj = {name, lastName, hairColor};
    str = JSON.stringify(obj);
    console.log(str);
}

toJson('George', 'Jones', 'Brown');
toJson('Peter', 'Smith', 'Blond');