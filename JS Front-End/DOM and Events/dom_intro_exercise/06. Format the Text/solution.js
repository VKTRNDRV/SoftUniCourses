function solve() {
    document.querySelector('#formatItBtn').addEventListener('click', onClick);

    function onClick(){
        let sentences = document.getElementById("input").value.split(".");
        let outputParent = document.getElementById("output");
        
        let paragraphText = "";
        let sentence = sentences[0]
        if(sentence.length > 0){
            paragraphText += sentence + ".";
        }
        let innerHTML = "";
        for(let i = 1; i < sentences.length; i++){
            let sentence = sentences[i];
            if(sentence.length > 0){
                paragraphText += sentence + ".";
            }
            
            if((i + 1) % 3 == 0 && paragraphText.length > 0){
                innerHTML += `<p>${paragraphText}</p>`;
                paragraphText = "";
            }
        }

        if(paragraphText.length > 0){
            innerHTML += `<p>${paragraphText}</p>`;
        }

        outputParent.innerHTML = innerHTML;
    }
}