function printPhonebook(input){
    let phoneBook = {};
    for(let token of input){
        let name = token.split(' ')[0];
        let number = token.split(' ')[1];
        phoneBook[name] = number;
    }

    for(let key in phoneBook){
        console.log(`${key} -> ${phoneBook[key]}`);
    }
}

printPhonebook(['George 0552554',
'Peter 087587',
'George 0453112',
'Bill 0845344']);