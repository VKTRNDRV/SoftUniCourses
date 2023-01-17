function trapezoidArea(input){
    let base1 = Number(input[0]);
    let base2 = Number(input[1]);
    let height = Number(input[2]);

    let area = ((base1 + base2)*height) / 2;

    console.log(area.toFixed(2));
}