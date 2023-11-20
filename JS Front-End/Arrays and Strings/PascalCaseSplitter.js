function splitAndJoinPascalCase(inputString) {
    let words = inputString.split(/(?=[A-Z])/);

    let result = words.join(', ');

    console.log(result);
}

splitAndJoinPascalCase('SplitMeIfYouCanHaHaYouCantOrYouCan');
splitAndJoinPascalCase('HoldTheDoor');
splitAndJoinPascalCase('ThisIsSoAnnoyingToDo');