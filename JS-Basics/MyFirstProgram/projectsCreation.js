function projectsCreation(input){
    let architectName = input[0];
    let numberOfProjects = input[1];
    let hoursNeeded = numberOfProjects*3;
    let output = "The architect " + architectName + " will need " + hoursNeeded + " hours to complete " + numberOfProjects + " project/s.";
    
    console.log(output);
}

projectsCreation(["George", 4]);