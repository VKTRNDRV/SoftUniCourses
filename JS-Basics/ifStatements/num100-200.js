function num100To200(input){
    let numInput = Number(input[0]);

    if(numInput < 100){
        console.log("Less than 100");
    }else if(numInput >= 100 && numInput <= 200){
        console.log("Between 100 and 200");
    }else if(numInput > 200){
        console.log("Greater than 200");
    }
}

num100To200(["210"]);