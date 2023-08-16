function parseCats(input){
    class Cat {
        constructor(name, age){
            this.name = name;
            this.age = age;
        }

        meow() {
            console.log(`${this.name}, age ${this.age} says Meow`);
        }
    }

    for(let catInfo of input){
        let name = catInfo.split(' ')[0];
        let age = catInfo.split(' ')[1];
        let cat = new Cat(name, age);
        cat.meow();
    }
}


parseCats(['Mellow 2', 'Tom 5']);
console.log('====================================================')
parseCats(['Candy 1', 'Poppy 3', 'Nyx 2']);