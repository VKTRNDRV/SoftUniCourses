function toggle() {
    let button = document.getElementsByClassName("button")[0];
    let extra = document.getElementById("extra");

    switch(button.textContent){
        case "More":
            button.textContent = "Less";
            extra.style.display = "block";
            break;
        case "Less":
            button.textContent = "More";
            extra.style.display = "none";
            break;
    }
}