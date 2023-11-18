function charsToString(firstChar, secondChar, thirdChar){
    let output = firstChar;
    output += secondChar;
    output += thirdChar;

    console.log(output);
}

function reversedCharsToString(firstChar, secondChar, thirdChar){
    let output = thirdChar + " ";
    output += secondChar + " ";
    output += firstChar;

    console.log(output);
}


charsToString('a', 'b', 'c');
charsToString('%', '2', 'o');
charsToString('1', '5', 'p');


reversedCharsToString('A', 'B', 'C');
reversedCharsToString('%', '2', 'o');
reversedCharsToString('1', '5', 'p');