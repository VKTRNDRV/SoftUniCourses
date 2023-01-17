function areaOfFigures(input){
    let figureType = input[0];
    let secondInput = input[1];
    let thirdInput = input[2];

    let area;

    if(figureType == "square"){
        let sideLength = Number(secondInput);

        area = sideLength*sideLength;
    }

    if(figureType == "rectangle"){
        let side1 = Number(secondInput);
        let side2 = Number(thirdInput);

        area = side1*side2;
    }

    if(figureType == "circle"){
        let radius = Number(secondInput);

        area = Math.PI * Math.pow(radius, 2);
    }

    if(figureType == "triangle"){
        let side = Number(secondInput);
        let height = Number(thirdInput);

        area = (side*height)/2;
    }

    area = Math.round(area*1000);
    area = area / 1000;

    console.log(figureType);
    console.log(area);
}

areaOfFigures(["triangle","4.5","20"]);