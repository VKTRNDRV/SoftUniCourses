function printCharsInRange(char1, char2){
    let firstChar = Math.min(char1.charCodeAt(0), char2.charCodeAt(0));
    let secondChar = Math.max(char1.charCodeAt(0), char2.charCodeAt(0));

    let output = "";
    for(let i = firstChar + 1; i < secondChar; i++){
        output += ` ${String.fromCharCode(i)}`;
    }

    console.log(output);
}

printCharsInRange('a',
'd'
);

printCharsInRange('#',
':'
);

printCharsInRange('C',
'#'
);