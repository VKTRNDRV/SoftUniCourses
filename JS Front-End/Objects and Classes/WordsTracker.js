function printCountOfWords(input){
    let targetWords = input[0].split(" ");
    let wordsCount = {};

    for(let testWord of targetWords){
        let count = 0;
        for(let i = 1; i < input.length; i++){
            let currentWord = input[i];
            if(testWord === currentWord){
                count++;
            }
        }

        wordsCount[testWord] = count;
    }

    let entries = Object.entries(wordsCount)
    .sort(([firstKey, firstValue], [secondKey, secondValue]) => secondValue - firstValue);

    for(let entry of entries){
        console.log(`${entry[0]} - ${entry[1]}`);
    }
}

printCountOfWords(
    [
    'this sentence', 
    'In', 'this', 'sentence', 'you', 'have', 'to', 'count', 'the', 'occurrences', 'of', 'the', 'words', 'this', 'and', 'sentence', 'because', 'this', 'is', 'your', 'task'
    ]
        
);

printCountOfWords(
    [
        'is the', 
        'first', 'sentence', 'Here', 'is', 'another', 'the', 'And', 'finally', 'the', 'the', 'sentence'
    ]    
);