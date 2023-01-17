function trainingLab(input){

    let labHeightCM = Number(input[0])*100;
    let labWidthCM = Number(input[1])*100;

    let alleyHeightCM = 100;

    let workspaceHeightCM = 120;
    let workspaceWidthCM = 70;

    let columnsOfWorkspaces = Math.floor((labHeightCM) / workspaceHeightCM);
    let rowsOfWorkspaces = Math.floor((labWidthCM - alleyHeightCM) / workspaceWidthCM);

    let numOfWorkspaces = (columnsOfWorkspaces*rowsOfWorkspaces) - 3;

    console.log(numOfWorkspaces);
}

trainingLab(["15","8.9"]);


