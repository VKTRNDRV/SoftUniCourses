function cityTaxes(name, population, treasury){
    let obj = {
        name: name, 
        population: population, 
        treasury: treasury,
        taxRate: 10,
        collectTaxes() {
            this.treasury += (this.population * this.taxRate);
        },
        applyGrowth(percentage){
            this.population += Math.round((this.population * (percentage/100)));
        },
        applyRecession(percentage){
            this.treasury -= Math.round((this.treasury * (percentage/100)));
        }
    };
    return obj;
}

const city =cityTaxes('Tortuga',7000,15000);
city.collectTaxes();
console.log(city.treasury);
city.applyGrowth(5);
console.log(city.population);