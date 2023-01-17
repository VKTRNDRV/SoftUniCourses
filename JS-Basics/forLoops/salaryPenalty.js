function salaryPenalty(input){

    let numOfTabsOpen = Number(input[0]);
    let salary = Number(input[1]);

    const tabsOpen = input;
    tabsOpen.shift();
    tabsOpen.shift();

    for(let i = 0; i <= tabsOpen.length-1; i++){
        switch(tabsOpen[i]){
            case "Facebook":
                salary -= 150;
                break;

            case "Instagram":
                salary -= 100;
                break;

            case "Reddit":
                salary -= 50;
                break;
            default:
                break;
        }

        if(salary <= 0){
            console.log("You have lost your salary.");
            break;
        }
    }

    if(salary > 0){
        console.log(salary);
    }
}

salaryPenalty(["3",
"500",
"Facebook",
"Stackoverflow.com",
"softuni.bg"])
;