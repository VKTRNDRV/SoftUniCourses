function getInformation(speed, areaName){
    let maxSpeedAreas = {
        'motorway': 130,
        'interstate': 90,
        'city': 50,
        'residential': 20
    }

    let maxSpeed = maxSpeedAreas[areaName];

    if(speed <= maxSpeed){
        console.log(`Driving ${speed} km/h in a ${maxSpeed} zone`);
        return;
    }

    let speedOverTheLimit = speed - maxSpeed;
    let status;
    if(speedOverTheLimit > 40){
        status = "reckless driving";

    }else if(speedOverTheLimit > 20){
        status = "excessive speeding";

    }else{
        status = "speeding";
    }

    console.log(`The speed is ${speedOverTheLimit} km/h faster than the allowed speed of ${maxSpeed} - ${status}`);
}

getInformation(40, 'city');
getInformation(21, 'residential');
getInformation(120, 'interstate');
getInformation(200, 'motorway');