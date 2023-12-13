function solve(input){
    let initialCount = Number(input.shift());
    let assigneesTasks = {};

    // insert initial
    while(initialCount > 0){
        let [assignee, taskId, title, status, estimatedPoints] 
        = input.shift().split(":");

        if(!assigneesTasks.hasOwnProperty(assignee)){
            assigneesTasks[assignee] = [];
        }

        assigneesTasks[assignee].push({taskId, title, status, estimatedPoints});

        initialCount--;
    }

    // modify as per commands
    while(input.length > 0){
        let command = input.shift().split(":");
        let assignee = command[1];

        if(!assigneesTasks.hasOwnProperty(assignee)){
            console.log(`Assignee ${assignee} does not exist on the board!`);
            continue;
        }

        switch(command[0]){
            case "Add New":
                // let [taskId, title, status, estimatedPoints] 
                // = command.splice(0, 2);
                let taskId = command[2];
                let title = command[3];
                let status = command[4];
                let estimatedPoints = command[5];
                assigneesTasks[assignee]
                .push({taskId, title, status, estimatedPoints})
                break;

            case "Change Status":
                let isFound = false;
                let taskToChangeId = command[2];
                let statusNew = command[3];
                let targetAssigneeTasks = assigneesTasks[assignee]
                for(let i = 0; i < targetAssigneeTasks.length; i++){
                    if(targetAssigneeTasks[i].taskId == taskToChangeId){
                        isFound = true;
                        targetAssigneeTasks[i].status = statusNew;
                    }
                }

                if(!isFound){
                    console.log(`Task with ID ${taskToChangeId} does not exist for ${assignee}!`);
                }
                break;

            case "Remove Task":
                let index = Number(command[2]);
                if(index < 0 || index >= assigneesTasks[assignee].length){
                    console.log(`Index is out of range!`);
                    continue;
                }
                assigneesTasks[assignee].splice(index, 1);
                break;
        }
    }

    // calc and print info
    let toDoPoints = 0;
    let inProgressPoints = 0;
    let codeReviewPoints = 0;
    let donePoints = 0;
    for(let tasks of Object.values(assigneesTasks)){
        for(let task of tasks){
            switch(task.status){
                case 'ToDo':
                    toDoPoints += Number(task.estimatedPoints);
                    break;

                case 'In Progress':
                    inProgressPoints += Number(task.estimatedPoints);
                    break;

                case 'Code Review':
                    codeReviewPoints += Number(task.estimatedPoints);
                    break;

                case 'Done':
                    donePoints += Number(task.estimatedPoints);
                    break;
            }
        }
    }

    console.log(`ToDo: ${toDoPoints}pts`);
    console.log(`In Progress: ${inProgressPoints}pts`);
    console.log(`Code Review: ${codeReviewPoints}pts`);
    console.log(`Done Points: ${donePoints}pts`);

    if(donePoints >= (toDoPoints + inProgressPoints 
        + codeReviewPoints)){
        console.log(`Sprint was successful!`);
    }else{
        console.log(`Sprint was unsuccessful...`);
    }
}

solve([
    '5',
    'Kiril:BOP-1209:Fix Minor Bug:ToDo:3',
    'Mariya:BOP-1210:Fix Major Bug:In Progress:3',
    'Peter:BOP-1211:POC:Code Review:5',
    'Georgi:BOP-1212:Investigation Task:Done:2',
    'Mariya:BOP-1213:New Account Page:In Progress:13',
    'Add New:Kiril:BOP-1217:Add Info Page:In Progress:5',
    'Change Status:Peter:BOP-1290:ToDo',
    'Remove Task:Mariya:1',
    'Remove Task:Joro:1',
    ]);
console.log("-------------------------------------------------------------");
solve([
    '4',
    'Kiril:BOP-1213:Fix Typo:Done:1',
    'Peter:BOP-1214:New Products Page:In Progress:2',
    'Mariya:BOP-1215:Setup Routing:ToDo:8',
    'Georgi:BOP-1216:Add Business Card:Code Review:3',
    'Add New:Sam:BOP-1237:Testing Home Page:Done:3',
    'Change Status:Georgi:BOP-1216:Done',
    'Change Status:Will:BOP-1212:In Progress',
    'Remove Task:Georgi:3',
    'Change Status:Mariya:BOP-1215:Done',
]);