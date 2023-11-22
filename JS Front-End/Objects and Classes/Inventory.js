function createHeroRegister(inputArray) {
    let heroes = [];
  
    inputArray.forEach((heroData) => {
      const [heroName, heroLevel, itemsString] = heroData.split(' / ');
  
      const level = Number(heroLevel);
  
      const hero = {
        name: heroName,
        level: level,
        items: itemsString.split(', '), // Split items into an array
      };
  
      heroes.push(hero);
    });
  
    heroes.sort((a, b) => a.level - b.level);
  
    heroes.forEach((hero) => {
      console.log(`Hero: ${hero.name}`);
      console.log(`level => ${hero.level}`);
      console.log(`items => ${hero.items.join(', ')}`);
    });
  }

  createHeroRegister(
    [
    'Isacc / 25 / Apple, GravityGun',
    'Derek / 12 / BarrelVest, DestructionSword',
    'Hes / 1 / Desolator, Sentinel, Antara'
    ]     
  );

  createHeroRegister(
    [
    'Batman / 2 / Banana, Gun',
    'Superman / 18 / Sword',
    'Poppy / 28 / Sentinel, Antara'
    ]    
  );