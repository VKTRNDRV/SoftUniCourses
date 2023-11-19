function performSpecialSort(array){
    array.sort(function(a, b){
        return a - b;
    });

    let sortedArray = [];
    while(array.length > 0){
        sortedArray.push(array.shift());

        if(array.length > 0){
            sortedArray.push(array.pop());
        }
    }

    return sortedArray;
}

console.log(performSpecialSort([1, 65, 3, 52, 48, 63, 31, -3, 18, 56]));