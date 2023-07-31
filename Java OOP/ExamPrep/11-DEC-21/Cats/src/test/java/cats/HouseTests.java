package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HouseTests {

    private House house;


    @Before
    public void setUp(){
        this.house = new House("house1", 2);
    }



    // get name
    @Test
    public void testGetName(){
        Assert.assertEquals("house1", house.getName());
    }


    // set name
    @Test
    public void testSetName(){
        House house2 = new House("house2", 2);
        Assert.assertEquals("house2", house2.getName());
    }

    // set null name
    @Test(expected = NullPointerException.class)
    public void testSetNullName(){
        new House(null, 2);
    }

    // set whitespace name
    @Test(expected = NullPointerException.class)
    public void testSetWhitespaceName() {
        new House("   ", 2);
    }

    // get capacity
    @Test
    public void testGetCapacity() {
        Assert.assertEquals(2, house.getCapacity());
    }


    // set capacity
    @Test
    public void testSetCapacity() {
        House house3 = new House("house3", 3);
        Assert.assertEquals(3, house3.getCapacity());
    }


    // set capacity below zero
    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityBelowZero() {
        new House("house4", -1);
    }


    // get count
    @Test
    public void testGetCount() {
        Assert.assertEquals(0, house.getCount());
    }


    // add cat
    @Test
    public void testAddCat() {
        Cat cat = new Cat("Tom");
        house.addCat(cat);
        Assert.assertEquals(1, house.getCount());
    }

    // add cat to full house
    @Test(expected = IllegalArgumentException.class)
    public void testAddCatToFullHouse() {
        Cat cat1 = new Cat("Tom");
        Cat cat2 = new Cat("Jerry");
        Cat cat3 = new Cat("Spike");
        house.addCat(cat1);
        house.addCat(cat2);
        house.addCat(cat3); // Should throw IllegalArgumentException
    }


    // remove cat
    @Test
    public void testRemoveCat() {
        Cat cat = new Cat("Tom");
        house.addCat(cat);
        house.removeCat("Tom");
        Assert.assertEquals(0, house.getCount());
    }


    // remove non-existent cat
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNonExistentCat() {
        house.removeCat("Tom"); // Should throw IllegalArgumentException
    }


    // cat for sale
    @Test
    public void testCatForSale() {
        Cat cat = new Cat("Tom");
        house.addCat(cat);
        Cat soldCat = house.catForSale("Tom");
        Assert.assertFalse(soldCat.isHungry());
    }


    // sell non-existent cat
    @Test(expected = IllegalArgumentException.class)
    public void testSellNonExistentCat() {
        house.catForSale("Tom"); // Should throw IllegalArgumentException
    }


    // statistics
    @Test
    public void testStatistics() {
        Cat cat1 = new Cat("Tom");
        Cat cat2 = new Cat("Jerry");
        house.addCat(cat1);
        house.addCat(cat2);
        Assert.assertEquals("The cat Tom, Jerry is in the house house1!", house.statistics());
    }

}
