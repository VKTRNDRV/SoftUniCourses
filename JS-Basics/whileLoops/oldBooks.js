function oldBooks(input){

    let bookName = String(input[0]);

    input.shift();

    let counter = 0;
    let isBookFound = false;

    let index = 0;
    while(index < input.length){
        if(input[index] === bookName){
            console.log(`You checked ${counter} books and found it.`);
            isBookFound = true;
            break;
        }

        if(input[index] === "No More Books"){
            break;
        }

        counter++;
        index++;
    }

    if(isBookFound == false){
        console.log("The book you search is not here!");
        console.log(`You checked ${counter} books.`)
    }
}

oldBooks(["Bourne",
"True Story",
"Forever",
"More Space",
"The Girl",
"Spaceship",
"Strongest",
"Profit",
"Tripple",
"Stella",
"The Matrix",
"Bourne"])
;