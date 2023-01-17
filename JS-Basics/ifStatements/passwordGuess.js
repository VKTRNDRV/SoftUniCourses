function passwordGuess(input){
    let inputText = input[0];
    let passW = "s3cr3t!P@ssw0rd";

    if(inputText == passW){
        console.log("Welcome");
    }else{
        console.log("Wrong password!")
    }
}

passwordGuess(["s3cr3t!P@ssw0rd"]);