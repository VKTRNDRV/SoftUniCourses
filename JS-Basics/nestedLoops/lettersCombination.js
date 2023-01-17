function lettersCombination(input){

    let beginChar = String(input[0]);
    let endChar = String(input[1]);
    let skipChar = String(input[2]);

    let beginCharIndex = beginChar.charCodeAt(0);
    let endCharIndex = endChar.charCodeAt(0);
    let skipCharIndex = skipChar.charCodeAt(0);

    let validCombCount = 0;

    let output = "";

    let firstChar = beginChar;
    let secondChar = beginChar;
    let thirdChar = beginChar;

    let i1 = beginCharIndex;
    while(i1 <= endCharIndex){
        firstChar = String.fromCharCode(i1);

        let i2 = beginCharIndex;
        while(i2 <= endCharIndex){
            secondChar = String.fromCharCode(i2);

            let i3 = beginCharIndex;
            while(i3 <= endCharIndex){
                thirdChar = String.fromCharCode(i3);

                if(firstChar.charCodeAt(0) != skipCharIndex && secondChar.charCodeAt(0) != skipCharIndex && thirdChar.charCodeAt(0) != skipCharIndex){
                    validCombCount++;
                    output += firstChar + secondChar + thirdChar + " ";
                }

                i3++;
            }
            //i3 = beginCharIndex;
            i2++;
        }
        //i2 = beginCharIndex;
        i1++;
    }

    output += validCombCount;

    console.log(output);
}

lettersCombination(["a","c","z"]);