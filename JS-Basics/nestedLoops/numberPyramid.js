function numberPyramid(input){

    let endNum = input[0];

    let rowLength = 1;
    let rowString = "";

    let currentNum = 1;
    let rowItemNum = 1
    while(currentNum <= endNum){

        while(rowItemNum <= rowLength && currentNum <= endNum){
            rowString += currentNum + " ";
            currentNum++;
            rowItemNum++;
        }
        console.log(rowString);
        rowString = "";
        rowItemNum = 1;
        rowLength++;
    }
}

numberPyramid(["999"]);