function extractText() {
    let listElements = Array.from(document.getElementById("items").children);
    let result = "";
    for(let liElement of listElements){
        result += liElement.textContent;
        result += "\n";
    }

    outputElement = document.getElementById("result");
    outputElement.value = result;
}