function findWordInText(word, text) {
    const lowercasedWord = word.toLowerCase();
    const lowercasedText = text.toLowerCase();

    const wordRegex = new RegExp(`\\b${lowercasedWord}\\b`, 'g');

    const matches = lowercasedText.match(wordRegex);

    if (matches) {
        console.log(matches.join(', '));
    } else {
        console.log(`${word} not found!`);
    }
}

findWordInText('javaScript', 'JavaScript is the best programming language');
findWordInText('python','JavaScript is the best programming language');