function formatGrade(grade){
    let output = "";
    if(grade < 3){
        console.log("Fail (2)");
        return;
    }else if(grade < 3.5){
        output += "Poor ";
    }else if(grade < 4.5){
        output += "Good ";
    }else if(grade < 5.5){
        output += "Very good ";
    }else{
        output += "Excellent "
    }

    output += `(${grade.toFixed(2)})`;
    console.log(output);
}

formatGrade(3.33);
formatGrade(4.50);
formatGrade(2.99);
formatGrade(5.90);
