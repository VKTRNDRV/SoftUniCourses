function primePairs(input){

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

    let minFirstPair = Number(input[0]);
    let minSecondPair = Number(input[1]);
    let maxFirstPair = minFirstPair + Number(input[2]);
    let maxSecondPair = minSecondPair + Number(input[3]);

    let currentFirstPair = minFirstPair;
    while(currentFirstPair <= maxFirstPair){

        let currentSecondPair = minSecondPair;
        while(currentSecondPair <= maxSecondPair){

            if(isPrime(currentFirstPair) == true && isPrime(currentSecondPair) == true){
                console.log(`${currentFirstPair}${currentSecondPair}`);
            }
            currentSecondPair++;
        }
        currentFirstPair++;
    }
}
primePairs(["10","30","9","6"]);