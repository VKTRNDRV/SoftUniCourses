function printEmployees(names){
    let employees = [];

    for(let employeeName of names){
        let employee = {};
        employee.name = employeeName;
        employee.personalNumber = employee.name.length;
        employees.push(employee);
    }

    for(employee of employees){
        console.log(`Name: ${employee.name} -- Personal Number: ${employee.personalNumber}`);
    }
}

printEmployees(
    [
    'Silas Butler',
    'Adnaan Buckley',
    'Juan Peterson',
    'Brendan Villarreal'
    ]
        
);

printEmployees(
    [
    'Samuel Jackson',
    'Will Smith',
    'Bruce Willis',
    'Tom Holland'
    ]
        
);