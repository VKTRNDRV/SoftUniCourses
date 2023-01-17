function numberInRange(input){

    let number = Number(input[0]);

    let result;

    if(number >= -100 && number != 0 && number <= 100){

        result = "Yes";

    }else{

        result = "No";

    }

    console.log(result);

}