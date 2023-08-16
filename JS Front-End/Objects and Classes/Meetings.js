function scheduleMeetings(input){
    let week = {};
    for(let token of input){
        let day = token.split(' ')[0];
        let name = token.split(' ')[1];
        if(week.hasOwnProperty(day)){
            console.log(`Conflict on ${day}!`);
        }else{
            week[day] = name;
            console.log(`Scheduled for ${day}`);
        }
    }

    for(let day in week){
        console.log(`${day} -> ${week[day]}`);
    }
}

scheduleMeetings(['Monday Peter',
'Wednesday Bill',
'Monday Tim',
'Friday Tim']);

console.log();

scheduleMeetings(['Friday Bob',
'Saturday Ted',
'Monday Bill',
'Monday John',
'Wednesday George']);