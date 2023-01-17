function personalTitles(input){

    let age = Number(input[0]);

    let gender = String(input[1]);

    let title;

    if(gender == "m"){
        if(age < 16){

            title = "Master";
            
        }else if(age >= 16){

            title = "Mr.";

        }

    }else if(gender == "f"){
        if(age < 16){

            title = "Miss";
            
        }else if(age >= 16){
            
            title = "Ms."

        }
    }

    console.log(title);

}

personalTitles(["13.5",
"m"])
;