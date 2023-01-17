function readText(input){

    const strings = input;

    let index = 0;
    while(strings[index] !== "Stop"){
        console.log(strings[index]);
        index++;
    }
}

readText(["Sofia",
"Berlin",
"Moscow",
"Athens",
"Madrid",
"London",
"Paris",
"Stop",
"AfterStop"])
;