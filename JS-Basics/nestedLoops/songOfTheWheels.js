function songOfTheWheels(input){

    let controlSum = Number(input[0]);
    let validCount = 0;
    let output = "";
    let password = "";
    let passwordFound = false;
    
    let a = 1
    while(a <= 9){

        let b = 1;
        while(b <= 9){

            let c = 1;
            while(c <= 9){

                let d = 1;
                while(d <= 9){

                    if(a*b + c*d == controlSum && a<b && c>d){
                        validCount++;
                        output += String(a)+String(b)+String(c)+String(d) + " ";
                    }
                    if(validCount == 4 && passwordFound == false){
                        password += String(a)+String(b)+String(c)+String(d);
                        passwordFound = true;
                    }
                    d++;
                }
                c++;
            }
            b++;
        }
        a++;
    }
    if(validCount == 0){
        console.log(`No!`);
    }else if(validCount > 0 && validCount < 4){
        console.log(output);
        console.log(`No!`);
    }else{
        console.log(output);
        console.log(`Password: ${password}`)
    }
}

songOfTheWheels(["55"]);
