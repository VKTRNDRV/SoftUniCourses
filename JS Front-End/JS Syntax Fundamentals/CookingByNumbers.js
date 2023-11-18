function cookingByNumbers(number, op1, op2, op3, op4, op5) {
    let result = Number(number);

    function chop(num) {
        return num / 2;
    }

    function dice(num) {
        return Math.sqrt(num);
    }

    function spice(num) {
        return num + 1;
    }

    function bake(num) {
        return num * 3;
    }

    function fillet(num) {
        return num - (num * 0.2);
    }

    const operations = {
        chop,
        dice,
        spice,
        bake,
        fillet
    };

    const operationNames = [op1, op2, op3, op4, op5];

    for (let i = 0; i < operationNames.length; i++) {
        result = operations[operationNames[i]](result);
        console.log(result);
    }
}

cookingByNumbers('32', 'chop', 'chop', 'chop', 'chop', 'chop');
cookingByNumbers('9', 'dice', 'spice', 'chop', 'bake', 'fillet');