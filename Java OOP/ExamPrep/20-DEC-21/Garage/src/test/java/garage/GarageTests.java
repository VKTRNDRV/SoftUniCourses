package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GarageTests {

    private Garage garage;



    @Before
    public void setUp() {
        this.garage = new Garage();
        Car car1 = new Car("Brand1", 200, 20000);
        Car car2 = new Car("Brand2", 180, 18000);
        Car car3 = new Car("Brand3", 220, 25000);
        Car car4 = new Car("Brand4", 250, 30000);

        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);
        garage.addCar(car4);
    }


    @Test
    public void testAddCar() {
        Car newCar = new Car("BrandNew", 180, 21000);
        int initialCount = garage.getCount();
        garage.addCar(newCar);
        Assert.assertEquals(initialCount + 1, garage.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCarNull() {
        garage.addCar(null);
    }

    @Test
    public void testGetCars() {
        List<Car> cars = garage.getCars();
        Assert.assertEquals(4, cars.size());
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(4, garage.getCount());
    }

    @Test
    public void testFindAllCarsWithMaxSpeedAbove() {
        List<Car> carsAbove200 = garage.findAllCarsWithMaxSpeedAbove(200);
        Assert.assertEquals(2, carsAbove200.size());
    }

    @Test
    public void testGetTheMostExpensiveCar() {
        Car mostExpensiveCar = garage.getTheMostExpensiveCar();
        Assert.assertNotNull(mostExpensiveCar);
        //Assert.assertTrue(30000, mostExpensiveCar.getPrice() );
        Assert.assertEquals(30000,mostExpensiveCar.getPrice(), 0.1);
    }

    @Test
    public void testFindAllCarsByBrand() {
        List<Car> brand1Cars = garage.findAllCarsByBrand("Brand1");
        Assert.assertEquals(1, brand1Cars.size());
        Assert.assertEquals("Brand1", brand1Cars.get(0).getBrand());

        List<Car> brand2Cars = garage.findAllCarsByBrand("Brand2");
        Assert.assertEquals(1, brand2Cars.size());
        Assert.assertEquals("Brand2", brand2Cars.get(0).getBrand());

        List<Car> nonExistentBrandCars = garage.findAllCarsByBrand("BrandX");
        Assert.assertEquals(0, nonExistentBrandCars.size());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetCarsReturnsUnmodifiableCollection() {
        List<Car> cars = garage.getCars();
        cars.add(new Car("NewBrand", 190, 21000));
    }

    @Test
    public void testGetTheMostExpensiveCarFromEmptyGarage() {
        garage = new Garage();
        Car mostExpensiveCar = garage.getTheMostExpensiveCar();
        Assert.assertNull(mostExpensiveCar);
    }

    @Test
    public void testFindAllCarsWithMaxSpeedAboveRidiculous(){
        List<Car> cars = garage.findAllCarsWithMaxSpeedAbove(10000);
        Assert.assertEquals(0, cars.size());
    }
}