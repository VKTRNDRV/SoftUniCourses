function uniquePINs(input){

    function isPrime(num) {
        if (num == 2 || num == 3)
          return true;
        if (num <= 1 || num % 2 == 0 || num % 3 == 0)
          return false;  
        for (let i = 5; i * i <= num ; i+=6)
          if (num % i == 0 || num % (i + 2) == 0)
            return false;
        return true;
      }

    let maxFirstDigit = Number(input[0]);
    let maxSecondDigit = Number(input[1]);
    let maxThirdDigit = Number(input[2]);

    let output = "";

    let firstDigit = 2;
    let secondDigit = 2;
    let thirdDigit = 2;

    let i1 = 2;
    while(i1 <= maxFirstDigit){
        firstDigit = i1;

        let i2 = 2;
        while(i2 <= maxSecondDigit){
            secondDigit = i2;

            let i3 = 2;
            while(i3 <= maxThirdDigit){
                thirdDigit = i3;

                if(firstDigit % 2 == 0 && (isPrime(secondDigit) == true && secondDigit <= 7) && thirdDigit % 2 == 0){

                    output += String(firstDigit) + " ";
                    output += String(secondDigit) + " ";
                    output += String(thirdDigit) + " ";
                    
                    console.log(output);
                }
                output = "";
                i3 += 2;
            }
            i2 += 1;
        }        
        i1 += 2;
    }
}

uniquePINs(["8","2","8"]);