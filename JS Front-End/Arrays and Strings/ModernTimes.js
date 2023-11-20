function printSpecialWords(string){

    let words = string.split(/\s+|[.,!]/);
    let isValid;

    for(let word of words){
        if(word.charAt(0) != "#"){
            continue;
        }
        if(word.length < 2){
            continue;
        }

        isValid = true;

        for(let i = 1; i < word.length; i++){
            let char = word.charAt(i);
            if((char < 'a' || char > 'z') && 
            (char < 'A' || char > 'Z')){
                isValid = false;
                break;
            }
        }

        if(isValid){
            console.log(word.substring(1));
        }
    }
}

printSpecialWords('Nowadays everyone uses # to tag a #special word in #socialMedia');
printSpecialWords('The symbol # is known #variously in English-speaking   #regions as the #number sign');