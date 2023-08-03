package toyStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ToyStoryTest {

    private ToyStore toyStore;

    @Before
    public void setUp(){
        toyStore = new ToyStore();
    }


    // getToyShelf returns toyShelf
    @Test
    public void getToyShelfReturnsToyShelf(){
        Assert.assertEquals(7, toyStore.getToyShelf().size());
    }

    // returned getToyShelf collection cannot be modified
    @Test(expected = UnsupportedOperationException.class)
    public void testReturnedToyShelfIsUnmodifiable(){
        toyStore.getToyShelf().put("H", new Toy("Teddy Bear", "id1"));
    }


    // addToy adds toy
    @Test
    public void testAddToyToShelf(){
        Toy toy = new Toy("Ball", "id1");
        try {
            String result = toyStore.addToy("A", toy);
            Assert.assertEquals("Toy:id1 placed successfully!", result);
            Assert.assertEquals(toy, toyStore.getToyShelf().get("A"));
        } catch (OperationNotSupportedException | IllegalArgumentException e) {
            Assert.fail("Exception not expected: " + e.getMessage());
        }
    }

    // addToy non-existing shelf throws exception
    @Test(expected = IllegalArgumentException.class)
    public void testAddToyToNonExistingShelf(){
        Toy toy = new Toy("Train", "id11");
        try {
            toyStore.addToy("X", toy);
        } catch (OperationNotSupportedException e) {
            Assert.fail("OperationNotSupportedException not expected: " + e.getMessage());
        }
    }

    // addToy to taken shelf throws exception
    @Test(expected = IllegalArgumentException.class)
    public void testAddToyToTakenShelf(){
        Toy toy1 = new Toy("Car", "id12");
        Toy toy2 = new Toy("Doll", "id13");
        try {
            toyStore.addToy("A", toy1);
            // Try to add another toy to the same shelf
            toyStore.addToy("A", toy2);
        } catch (OperationNotSupportedException e) {
            Assert.fail("OperationNotSupportedException not expected: " + e.getMessage());
        }
    }


    // addToy existing toy throws exception
    @Test
    public void testAddExistingToyToShelf(){
        Toy toy = new Toy("Ball", "id10");
        try {
            toyStore.addToy("A", toy);
            // Try to add the same toy again to another shelf
            toyStore.addToy("B", toy);
        } catch (OperationNotSupportedException e) {
            Assert.assertEquals("Toy is already in shelf!", e.getMessage());
            return;
        } catch (IllegalArgumentException e){
            Assert.fail();
        }
        Assert.fail();
    }


    // removeToy removes toy
    @Test
    public void testRemoveToyFromShelf(){
        Toy toy = new Toy("Car", "id15");
        try {
            toyStore.addToy("A", toy);
            String result = toyStore.removeToy("A", toy);
            Assert.assertEquals("Remove toy:id15 successfully!", result);
            Assert.assertNull(toyStore.getToyShelf().get("A"));
        } catch (OperationNotSupportedException | IllegalArgumentException e) {
            Assert.fail("Exception not expected: " + e.getMessage());
        }
    }

    // removeToy non-existing shelf throws exception
    @Test
    public void testRemoveToyFromNonExistingShelf(){
        Toy toy = new Toy("Car", "id22");
        try {
            toyStore.removeToy("X", toy);
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Shelf doesn't exists!", e.getMessage());
            return;
        }
        Assert.fail();
    }

    // removeToy toy not in shelf throws exception
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNonExistingToyFromShelf(){
        Toy toy1 = new Toy("Car", "id19");
        Toy toy2 = new Toy("Doll", "id33");
        try {
            toyStore.addToy("A", toy1);
            // Try to remove toy2 from shelf A, which doesn't have it
            toyStore.removeToy("A", toy2);
        } catch (OperationNotSupportedException e) {
            Assert.fail("OperationNotSupportedException not expected: " + e.getMessage());
        }
    }
}