function stockAndPrintStore(initialProducts, newProducts){
    let store = {};

    for(let i = 0; i < initialProducts.length; i+=2){
        let productName = initialProducts[i];
        let productCount = Number.parseInt(initialProducts[i+1]);
        store[productName] = productCount;
    }

    for(let i = 0; i < newProducts.length; i+=2){
        let productName = newProducts[i];
        let productCount = Number.parseInt(newProducts[i+1]);

        if(Object.keys(store).includes(productName)){
            store[productName] += productCount;
        }else{
            store[productName] = productCount;
        }
    }

    for(let entry of Object.entries(store)){
        console.log(`${entry[0]} -> ${entry[1]}`);
    }
}

stockAndPrintStore(
    [
    'Chips', '5', 'CocaCola', '9', 'Bananas', '14', 'Pasta', '4', 'Beer', '2'
    ],
    [
    'Flour', '44', 'Oil', '12', 'Pasta', '7', 'Tomatoes', '70', 'Bananas', '30'
    ]
        
);
stockAndPrintStore(
    [
    'Salt', '2', 'Fanta', '4', 'Apple', '14', 'Water', '4', 'Juice', '5'
    ],
    [
    'Sugar', '44', 'Oil', '12', 'Apple', '7', 'Tomatoes', '7', 'Bananas', '30'
    ]
        
);