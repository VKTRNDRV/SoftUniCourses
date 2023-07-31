package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FarmvilleTests {

    private Farm farm;

    @Before
    public void setUp(){
        this.farm = new Farm("farm1", 2);
    }

    // get count
    @Test
    public void getCount(){
        // Initially, the farm is empty
        Assert.assertEquals(farm.getCount(), 0);

        // Add an animal to the farm
        farm.add(new Animal("Cow", 10));
        Assert.assertEquals(farm.getCount(), 1);

        // Add another animal to the farm
        farm.add(new Animal("Sheep", 10));
        Assert.assertEquals(farm.getCount(), 2);
    }

    // get name
    @Test
    public void getName(){
        Assert.assertEquals(farm.getName(), "farm1");
    }

    // get capacity
    @Test
    public void getCapacity(){
        Assert.assertEquals(farm.getCapacity(), 2);
    }

    // add animal
    @Test
    public void addAnimal(){
        farm.add(new Animal("Horse", 50));
        Assert.assertEquals(farm.getCount(), 1);
    }

    // add animal to full farm - exception
    @Test(expected = IllegalArgumentException.class)
    public void addAnimalToFullFarm(){
        Farm smallFarm = new Farm("smallFarm", 1);
        smallFarm.add(new Animal("Dog", 10));
        smallFarm.add(new Animal("Cat", 10)); // This should throw an exception as the farm is full
    }

    // add existing type animal = exception
    @Test(expected = IllegalArgumentException.class)
    public void addExistingTypeAnimal(){
        farm.add(new Animal("Cow", 10));
        farm.add(new Animal("Cow", 10)); // Adding the same animal type should throw an exception
    }

    // remove animal
    @Test
    public void removeAnimal(){
        farm.add(new Animal("Horse", 50));
        Assert.assertTrue(farm.remove("Horse"));
    }

    // remove non-existing animal returns false
    @Test
    public void removeNonExistingAnimal(){
        boolean result = farm.remove("Dog"); // Trying to remove a non-existing animal
        Assert.assertFalse(result); // The result should be false
    }

    // create farm name null - exception
    @Test(expected = NullPointerException.class)
    public void createFarmWithNameNull(){
        new Farm(null, 5);
    }

    // create farm name whitespace - exception
    @Test(expected = NullPointerException.class)
    public void createFarmWithNameWhitespace(){
        new Farm("   ", 5);
    }

    // create farm negative capacity - exception
    @Test(expected = IllegalArgumentException.class)
    public void createFarmWithNegativeCapacity(){
        new Farm("farm2", -1);
    }
}
