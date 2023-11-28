function attachEventsListeners() {

    let daysBtn = document.getElementById("daysBtn");
    let hoursBtn = document.getElementById("hoursBtn");
    let minutesBtn = document.getElementById("minutesBtn");
    let secondsBtn = document.getElementById("secondsBtn");

    let daysBox = document.getElementById("days");
    let hoursBox = document.getElementById("hours");
    let minutesBox = document.getElementById("minutes");
    let secondsBox = document.getElementById("seconds");


    daysBtn.addEventListener("click", convertDays);
    hoursBtn.addEventListener("click", convertHours);
    minutesBtn.addEventListener("click", convertMinutes);
    secondsBtn.addEventListener("click", convertSeconds);

    function convertDays(){
        let days = parseFloat(daysBox.value)
        let hours = days * 24;
        let minutes = days * 1440;
        let seconds = days * 86400;

        displayAll(days, hours, minutes, seconds);
    }

    function convertHours(){
        let hours = parseFloat(hoursBox.value)
        let days = hours / 24;
        let minutes = hours * 60;
        let seconds = hours * 3600;

        displayAll(days, hours, minutes, seconds);

    }

    function convertMinutes(){
        let minutes = parseFloat(minutesBox.value)
        let days = minutes / 1440;
        let hours = minutes / 60;
        let seconds = minutes * 60;

        displayAll(days, hours, minutes, seconds);

    }

    function convertSeconds(){
        let seconds = parseFloat(secondsBox.value)
        let days = seconds / 86400;
        let hours = seconds / 3600;
        let minutes = seconds / 60;

        displayAll(days, hours, minutes, seconds);
    }


    function displayAll(days, hours, minutes, seconds){
        daysBox.value = days;
        hoursBox.value = hours;
        minutesBox.value = minutes;
        secondsBox.value = seconds;

        // daysBox.value = 1;
        // hoursBox.value = 2;
        // minutesBox.value = 3;
        // secondsBox.value = 4;
    }
}