function colorize() {
    let rows = Array.from(document.getElementsByTagName("tr"));
    for(let i = 1; i < rows.length; i+=2){
        let rowElement = rows[i];
        rowElement.style.backgroundColor = "teal";
    }
}