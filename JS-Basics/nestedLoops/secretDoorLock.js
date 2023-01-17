function secretDoorLock(input){

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

    let max000 = Number(input[0]);
    let max00 = Number(input[1]);
    let max0 = Number(input[2]);

    let ddd = 2;
    while(ddd <= max000){

        let dd = 1;
        while(dd <= max00){

            let d = 2;
            while(d <= max0){

                if(dd <= 7 && isPrime(dd) == true){
                    console.log(`${ddd} ${dd} ${d}`)
                }
                d+=2;
            }
            dd++;
        }
        ddd+=2;
    }
}

secretDoorLock(["8","2","8"]);