function calculatePrice(name, weightGrams, pricePerKg){
    let weightKG = weightGrams/1000;
    let price = pricePerKg * weightKG;
    console.log(`I need $${price.toFixed(2)} to buy ${weightKG.toFixed(2)} kilograms ${name}.`);
}

calculatePrice("orange", 2500, 1.80);
calculatePrice("apple", 1563, 2.35);