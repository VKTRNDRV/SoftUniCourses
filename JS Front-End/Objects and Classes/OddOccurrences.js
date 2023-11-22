function printOddOccurrences(input){
    let words = input.toLowerCase().split(" ");
    let wordsInOrder = [];
    let wordCounts = {};

    for(let word of words){
        if(wordCounts.hasOwnProperty(word)){
            wordCounts[word]++;
        }else{
            wordCounts[word] = 1;
            wordsInOrder.push(word);
        }
    }

    let filteredWords = Object.entries(wordCounts)
    .filter(e => e[1] % 2 == 1)
    .map(e => e[0]);

    let output = wordsInOrder.filter(w => filteredWords.includes(w));

    console.log(output.join(" "));
}

printOddOccurrences('Java C# Php PHP Java PhP 3 C# 3 1 5 C#');
printOddOccurrences('Cake IS SWEET is Soft CAKE sweet Food');