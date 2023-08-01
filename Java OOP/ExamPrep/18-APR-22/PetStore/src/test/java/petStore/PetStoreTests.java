package petStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PetStoreTests {

    private PetStore petStore;

    @Before
    public void setUp() {
        this.petStore = new PetStore();
        this.petStore.addAnimal(new Animal("specie1", 10, 100));
        this.petStore.addAnimal(new Animal("specie2", 15, 200));
    }


    @Test
    public void testGetAnimals() {
        Assert.assertEquals(2, petStore.getAnimals().size());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetAnimalsReturnsUnmodifiableCollection() {
        List<Animal> animals = petStore.getAnimals();
        animals.add(new Animal("specie3", 20, 300));
    }


    @Test
    public void testGetCount() {
        Assert.assertEquals(2, petStore.getCount());
    }


    @Test
    public void testFindAllAnimalsWithMaxKilograms() {
        List<Animal> animalsOver10Kg = petStore.findAllAnimalsWithMaxKilograms(12);
        Assert.assertEquals(1, animalsOver10Kg.size());
    }


    @Test
    public void testAddAnimal() {
        petStore.addAnimal(new Animal("specie3", 5, 50));
        Assert.assertEquals(3, petStore.getAnimals().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullAnimalThrowsException() {
        petStore.addAnimal(null);
    }


    @Test
    public void testGetTheMostExpensiveAnimal() {
        Animal mostExpensive = petStore.getTheMostExpensiveAnimal();
        Assert.assertNotNull(mostExpensive);
        Assert.assertEquals(200, mostExpensive.getPrice(), 0.001);
    }


    @Test
    public void testFindAllAnimalBySpecie() {
        List<Animal> specie1Animals = petStore.findAllAnimalBySpecie("specie1");
        Assert.assertEquals(1, specie1Animals.size());
    }

}

