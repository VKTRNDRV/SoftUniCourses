function buildingRooms(input){

    let totalFloors = Number(input[0]);
    let roomsPerFloor = Number(input[1]);

    let currentFloor = totalFloors;
    while(currentFloor > 0){
        if(currentFloor == totalFloors){
            let arr = [];
            for(let i = 1; i <= roomsPerFloor; i++){
                arr[i-1] = `L${currentFloor}${i-1} `;
            }
            console.log(arr.join(""));
            currentFloor--;
        }
        if(currentFloor == 0){
            break;
        }

        if(currentFloor % 2 == 0){
            let arr = [];
            for(let i = 1; i <= roomsPerFloor; i++){
                arr[i-1] = `O${currentFloor}${i-1} `;
            }
            console.log(arr.join(""));
        }else{
            let arr = [];
            for(let i = 1; i <= roomsPerFloor; i++){
                arr[i-1] = `A${currentFloor}${i-1} `;
            }
            console.log(arr.join(""));
        }

        currentFloor--;
    }
}

buildingRooms(["6", "4"]);