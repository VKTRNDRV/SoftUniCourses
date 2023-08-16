function toObject(firstName, lastName, age){
    let obj = {firstName, lastName, age};
    obj.firstName = firstName;
    obj.lastName = lastName;
    obj.age = age;
    return obj;
}

console.log(toObject("Peter", "Pan", 20));
console.log(toObject("George", "Smith", 18));