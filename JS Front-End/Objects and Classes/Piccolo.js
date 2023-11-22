function manageParkingLot(entries) {
    const parkingLot = new Set();

    entries.forEach(entry => {
        const [direction, carNumber] = entry.split(', ');

        if (direction === 'IN') {
            parkingLot.add(carNumber);
        } else if (direction === 'OUT') {
            parkingLot.delete(carNumber);
        }
    });

    const sortedCarNumbers = Array.from(parkingLot).sort();

    if (sortedCarNumbers.length === 0) {
        console.log('Parking Lot is Empty');
    } else {
        console.log(sortedCarNumbers.join('\n'));
    }
}

manageParkingLot(
    ['IN, CA2844AA',
    'IN, CA1234TA',
    'OUT, CA2844AA',
    'IN, CA9999TT',
    'IN, CA2866HI',
    'OUT, CA1234TA',
    'IN, CA2844AA',
    'OUT, CA2866HI',
    'IN, CA9876HH',
    'IN, CA2822UU']
);

manageParkingLot(
    ['IN, CA2844AA',
    'IN, CA1234TA',
    'OUT, CA2844AA',
    'OUT, CA1234TA']
);