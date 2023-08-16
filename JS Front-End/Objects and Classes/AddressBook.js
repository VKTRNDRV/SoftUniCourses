function processAddresses(input){
    let addressBook = {};
    for(let token of input){
        let name = token.split(':')[0];
        let address = token.split(':')[1];
        addressBook[name] = address;
    }

    let names = Object.keys(addressBook);
    names.sort((n1, n2) => n1.localeCompare(n2));
    for(let name of names){
        console.log(`${name} -> ${addressBook[name]}`);
    }
}


processAddresses(['Tim:Doe Crossing',
'Bill:Nelson Place',
'Peter:Carlyle Ave',
'Bill:Ornery Rd']);

console.log('-----------------------------------------------')

processAddresses(['Bob:Huxley Rd',
'John:Milwaukee Crossing',
'Peter:Fordem Ave',
'Bob:Redwing Ave',
'George:Mesta Crossing',
'Ted:Gateway Way',
'Bill:Gateway Way',
'John:Grover Rd',
'Peter:Huxley Rd',
'Jeff:Gateway Way',
'Jeff:Huxley Rd']);