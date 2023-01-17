function histogramPrint(input){

    const numsArray = input;
    
    let totalCount = Number(input[0]);

    let count000To199 = 0;
    let count200To399 = 0;
    let count400To599 = 0;
    let count600To799 = 0;
    let count800To999 = 0;

    let percent000To199 = 0;
    let percent200To399 = 0;
    let percent400To599 = 0;
    let percent600To799 = 0;
    let percent800To999 = 0;

    //calculating counts
    for(let i = 1; i <= (numsArray.length - 1); i++){
        let num = numsArray[i];

        if(num <= 199){
            count000To199++;

        }else if(num >= 200 && num <=399){
            count200To399++;

        }else if(num >= 400 && num <=599){
            count400To599++;
            
        }else if(num >= 600 && num <=799){
            count600To799++;
            
        }else if(num >= 800){
            count800To999++;
            
        }
    }

    //calculating percents
    percent000To199 = count000To199 / totalCount;
    percent200To399 = count200To399 / totalCount;
    percent400To599 = count400To599 / totalCount;
    percent600To799 = count600To799 / totalCount;
    percent800To999 = count800To999 / totalCount;

    console.log(`${(percent000To199*100).toFixed(2)}%`);
    console.log(`${(percent200To399*100).toFixed(2)}%`);
    console.log(`${(percent400To599*100).toFixed(2)}%`);
    console.log(`${(percent600To799*100).toFixed(2)}%`);
    console.log(`${(percent800To999*100).toFixed(2)}%`);
}

histogramPrint(["14",
"53",
"7",
"56",
"180",
"450",
"920",
"12",
"7",
"150",
"250",
"680",
"2",
"600",
"200"])
;