function repeatString(str, count){
    let output = '';
    while(count > 0){
        output += str;
        count--;
    }
    
    return output;
}


console.log(repeatString("abc", 3));
console.log(repeatString("String", 2));