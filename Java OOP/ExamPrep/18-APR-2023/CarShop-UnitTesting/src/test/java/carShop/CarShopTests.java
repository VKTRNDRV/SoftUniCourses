package carShop;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CarShopTests {

    private CarShop carShop;

    @Before
    public void setUp(){
        this.carShop = new CarShop();
    }


    // getCars returns collection of cars
    @Test
    public void testGetCarsReturnsCars(){
        Assert.assertNotNull(carShop.getCars());
    }

    // getCars returned collection cannot be modified
    @Test(expected = UnsupportedOperationException.class)
    public void testGetCarsCollectionImmutable() {
        carShop.getCars().add(new Car("TestModel", 200, 10000));
    }


    // getCount returns count
    @Test
    public void testGetCount() {
        Car car1 = new Car("Model1", 150, 20000);
        Car car2 = new Car("Model2", 180, 25000);

        carShop.add(car1);
        carShop.add(car2);

        Assert.assertEquals(2, carShop.getCount());
    }

    // findAllCarsWithMaxHorsePower returns all cars with horsepower over x
    @Test
    public void testFindAllCarsWithMaxHorsePower() {
        Car car1 = new Car("Model1", 150, 20000);
        Car car2 = new Car("Model2", 180, 25000);

        carShop.add(car1);
        carShop.add(car2);

        Assert.assertEquals(1, carShop.findAllCarsWithMaxHorsePower(170).size());
    }

    // findAllCarsWithMaxHorsePower returns empty list for ridiculous input
    @Test
    public void testFindAllCarsWithMaxHorsePowerRidiculousInput() {
        Car car1 = new Car("Model1", 150, 20000);
        Car car2 = new Car("Model2", 180, 25000);

        carShop.add(car1);
        carShop.add(car2);

        Assert.assertTrue(carShop.findAllCarsWithMaxHorsePower(1000).isEmpty());
    }


    // add adds car
    @Test
    public void testAddCar() {
        Car car1 = new Car("Model1", 150, 20000);

        carShop.add(car1);

        Assert.assertEquals(1, carShop.getCount());
    }

    // add null car throws NullPointerException
    @Test(expected = NullPointerException.class)
    public void testAddNullCarThrowsNullPointerException() {
        carShop.add(null);
    }


    // remove removes car and returns true
    @Test
    public void testRemoveCar() {
        Car car1 = new Car("Model1", 150, 20000);
        carShop.add(car1);

        boolean isRemoved = carShop.remove(car1);

        Assert.assertTrue(isRemoved);
        Assert.assertEquals(0, carShop.getCount());
    }

    // remove non-existing car returns false
    @Test
    public void testRemoveNonExistingCar() {
        Car car1 = new Car("Model1", 150, 20000);
        Car car2 = new Car("Model2", 180, 25000);
        carShop.add(car1);

        boolean isRemoved = carShop.remove(car2);

        Assert.assertFalse(isRemoved);
        Assert.assertEquals(1, carShop.getCount());
    }


    // getTheMostLuxuryCar return highest price car
    @Test
    public void testGetTheMostLuxuryCar() {
        Car car1 = new Car("Model1", 150, 20000);
        Car car2 = new Car("Model2", 180, 25000);
        carShop.add(car1);
        carShop.add(car2);

        Car mostLuxuryCar = carShop.getTheMostLuxuryCar();

        Assert.assertEquals(car2, mostLuxuryCar);
    }


    // findAllCarByModel returns all cars with model x
    @Test
    public void testFindAllCarByModel() {
        Car car1 = new Car("Model1", 150, 20000);
        Car car2 = new Car("Model2", 180, 25000);
        carShop.add(car1);
        carShop.add(car2);

        List<Car> foundCars = carShop.findAllCarByModel("Model1");

        Assert.assertEquals(1, foundCars.size());
        Assert.assertEquals(car1, foundCars.get(0));
    }

    // findAllCarByModel returns empty list for non-existing model
    @Test
    public void testFindAllCarByNonExistingModel() {
        Car car1 = new Car("Model1", 150, 20000);
        Car car2 = new Car("Model2", 180, 25000);
        carShop.add(car1);
        carShop.add(car2);

        List<Car> foundCars = carShop.findAllCarByModel("NonExistingModel");

        Assert.assertTrue(foundCars.isEmpty());
    }

}

