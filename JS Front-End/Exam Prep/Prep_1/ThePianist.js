function solve(input){
    let countOfPieces = Number(input[0]);
    let piecesMap = {};

    let i = 1;
    while(i <= countOfPieces){
        let pieceInfo = input[i].split("|");
        let pieceName = pieceInfo[0];
        let composer = pieceInfo[1];
        let key = pieceInfo[2];
        piecesMap[pieceName] = {composer, key};

        i++;
    }

    let currentLine = input[i];
    while(currentLine != "Stop"){
        let request = currentLine.split("|");
        let pieceName = request[1];

        switch(request[0]){
            case "Add":
                if(!piecesMap.hasOwnProperty(pieceName)){
                    let composer = request[2];
                    let key = request[3];
                    piecesMap[pieceName] = {composer, key};
                    console.log(`${pieceName} by ${composer} in ${key} added to the collection!`);
                }else{
                    console.log(`${pieceName} is already in the collection!`)
                }
                break;
            case "Remove":
                if(piecesMap.hasOwnProperty(pieceName)){
                    delete piecesMap[pieceName];
                    console.log(`Successfully removed ${pieceName}!`);
                }else{
                    console.log(`Invalid operation! ${pieceName} does not exist in the collection.`)
                }
                break;
            case "ChangeKey":
                if(piecesMap.hasOwnProperty(pieceName)){
                    let composer = piecesMap[pieceName].composer;
                    let key = request[2];
                    piecesMap[pieceName] = {composer, key};
                    console.log(`Changed the key of ${pieceName} to ${key}!`);
                }else{
                    console.log(`Invalid operation! ${pieceName} does not exist in the collection.`)
                }
                break;
        }

        i++;
        currentLine = input[i];
    }

    let entries = Object.entries(piecesMap);
    for (const [ piece, info ] of entries) {
        console.log(`${piece} -> Composer: ${info.composer}, Key: ${info.key}`);
    }
}

solve(
    [
        '3',
        'Fur Elise|Beethoven|A Minor',
        'Moonlight Sonata|Beethoven|C# Minor',
        'Clair de Lune|Debussy|C# Minor',
        'Add|Sonata No.2|Chopin|B Minor',
        'Add|Hungarian Rhapsody No.2|Liszt|C# Minor',
        'Add|Fur Elise|Beethoven|C# Minor',
        'Remove|Clair de Lune',
        'ChangeKey|Moonlight Sonata|C# Major',
        'Stop'  
      ]      
);
console.log("------------------------------------------------------------")
solve(
    [
        '4',
        'Eine kleine Nachtmusik|Mozart|G Major',
        'La Campanella|Liszt|G# Minor',
        'The Marriage of Figaro|Mozart|G Major',
        'Hungarian Dance No.5|Brahms|G Minor',
        'Add|Spring|Vivaldi|E Major',
        'Remove|The Marriage of Figaro',
        'Remove|Turkish March',
        'ChangeKey|Spring|C Major',
        'Add|Nocturne|Chopin|C# Minor',
        'Stop'
      ]      
);