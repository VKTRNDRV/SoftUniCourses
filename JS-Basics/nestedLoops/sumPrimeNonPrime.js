function sumPrimeNonPrime(input){

    const nums = [];
    let sumPrime = 0;
    let sumNonPrime = 0;

    for(let i = 0; i < input.length; i++){
        if(input[i] === "stop"){
            break;
        }
        nums[i] = input[i];
    }

    //checking if a num is prime, from wikipedia
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

    for(let i = 0; i < nums.length; i++){
        let currentNum = Number(nums[i]);
        if(currentNum < 0){
            console.log("Number is negative.");
        }else{ 

            if(isPrime(currentNum) == true){
                sumPrime += currentNum;
            }else{
                sumNonPrime += currentNum;
            }
        }
    }

    console.log(`Sum of all prime numbers is: ${sumPrime}`);
    console.log(`Sum of all non prime numbers is: ${sumNonPrime}`);
}

sumPrimeNonPrime(["30",
"83",
"33",
"-1",
"20",
"stop"])
;