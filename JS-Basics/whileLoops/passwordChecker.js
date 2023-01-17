function passwordChecker(input){

    let username = input[0];
    let password = input[1];
    let data = input[2];

    let index = 3;
    while(data != password){
        data = input[index];
        index++;
    }

    console.log(`Welcome ${username}!`);
}

passwordChecker(["Gosho",
"secret",
"secret1"])
;