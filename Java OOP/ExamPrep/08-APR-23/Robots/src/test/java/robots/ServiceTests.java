package robots;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ServiceTests {

    private Service service;

    @Before
    public void setUp(){
        this.service = new Service("service1", 5);
    }


    // getName returns name
    @Test
    public void  testGetNameReturnsName(){
        Assert.assertEquals("service1", this.service.getName());
    }


    // create service name null throws NullPointerException
    @Test(expected = NullPointerException.class)
    public void testCreateServiceWithNameNullThrowsNullPointerException() {
        new Service(null, 5);
    }

    // create service name whitespace throws NullPointerException
    @Test(expected = NullPointerException.class)
    public void testCreateServiceWithNameWhitespaceThrowsNullPointerException() {
        new Service("  ", 5);
    }


    // getCapacity returns capacity
    @Test
    public void testGetCapacityReturnsCapacity() {
        Assert.assertEquals(5, this.service.getCapacity());
    }


    // create service negative capacity throws IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testCreateServiceWithNegativeCapacityThrowsIllegalArgumentException() {
        new Service("service2", -1);
    }


    // getCount returns count of robots
    @Test
    public void testGetCountReturnsCountOfRobots() {
        Assert.assertEquals(0, this.service.getCount());
        this.service.add(new Robot("robot1"));
        Assert.assertEquals(1, this.service.getCount());
        this.service.add(new Robot("robot2"));
        Assert.assertEquals(2, this.service.getCount());
    }


    // add adds robot
    @Test
    public void testAddAddsRobot() {
        this.service.add(new Robot("robot1"));
        this.service.add(new Robot("robot2"));
        Assert.assertEquals(2, this.service.getCount());
    }

    // add to full service throws IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testAddToFullServiceThrowsIllegalArgumentException() {
        this.service.add(new Robot("robot1"));
        this.service.add(new Robot("robot2"));
        this.service.add(new Robot("robot3"));
        this.service.add(new Robot("robot4"));
        this.service.add(new Robot("robot5"));
        this.service.add(new Robot("robot6")); // Trying to add a robot to a full service
    }


    // remove removes robot
    @Test
    public void testRemoveRemovesRobot() {
        Robot robot1 = new Robot("robot1");
        this.service.add(robot1);
        this.service.add(new Robot("robot2"));
        this.service.remove("robot1");
        Assert.assertEquals(1, this.service.getCount());
    }

    // remove non-existing robot throws IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNonExistingRobotThrowsIllegalArgumentException() {
        this.service.add(new Robot("robot1"));
        this.service.remove("robot2"); // Trying to remove a robot that doesn't exist
    }


    // forSale sets robot isReadyForSale to false and returns robot
    @Test
    public void testForSaleSetsRobotNotReadyForSaleAndReturnsRobot() {
        Robot robot1 = new Robot("robot1");
        this.service.add(robot1);
        Robot soldRobot = this.service.forSale("robot1");
        Assert.assertFalse(robot1.isReadyForSale()); // Robot1 should be set not ready for sale
        Assert.assertEquals(robot1, soldRobot);
    }

    // forSale non-existing robot name throws IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testForSaleNonExistingRobotNameThrowsIllegalArgumentException() {
        this.service.forSale("robot1"); // Trying to sell a robot that doesn't exist
    }

}
