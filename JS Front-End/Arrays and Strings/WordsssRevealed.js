function revealWords(words, template){
    
    function isAllStars(checkWord){
        for(let i = 0; i < checkWord.length; i++){
            if(checkWord.charAt(i) != '*'){
                return false;
            }
        }

        return true;
    }

    let wordOptions = words.split(", ");
    let wordsInTemplate = template.split(" ");

    for(let i = 0; i < wordsInTemplate.length; i++){
        let currentWord = wordsInTemplate[i];
        if(!isAllStars(currentWord)){
            continue;
        }

        for(let wordToCheck of wordOptions){
            if(wordToCheck.length === currentWord.length){
                wordsInTemplate[i] = wordToCheck;
                break;
            }
        }
    }

    let output = wordsInTemplate.join(" ");
    return output;
}


console.log(revealWords('great', 'softuni is ***** place for learning new programming languages'));
console.log(revealWords('great, learning', 'softuni is ***** place for ******** new programming languages'));