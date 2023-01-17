function passwordGenerator(input){

    let n = Number(input[0]);
    let l = Number(input[1]);

    let output = "";

    let s1 = 1;
    while(s1 <= n){

        let s2 = 1;
        while(s2 <= n){

            let s3Index = 97;
            while(s3Index <= l+96){

                let s4Index = 97;
                while(s4Index <= l+96){

                    let s5 = 1;
                    while(s5<=n){

                        if(s5>s1 && s5>s2 && s5<=n){
                            output += `${s1}${s2}${String.fromCharCode(s3Index)}${String.fromCharCode(s4Index)}${s5} `;
                        }
                        s5++;
                    }
                    s4Index++;
                }
                s3Index++;
            }
            s2++;
        }
        s1++;
    }
    console.log(output);
}

passwordGenerator(["4","2"]);