package archeologicalExcavations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExcavationTests {

    private Excavation excavation;

    @Before
    public void setUp(){
        excavation = new Excavation("excavation1", 5);
        excavation.addArchaeologist(new Archaeologist("archaeologist1", 10));
        excavation.addArchaeologist(new Archaeologist("archaeologist2", 10));
    }


    @Test
    public void getCountReturnsCount(){
        Assert.assertEquals(2, excavation.getCount());
    }


    @Test
    public void getNameReturnsName() {
        Assert.assertEquals("excavation1", excavation.getName());
    }


    @Test
    public void getCapacityReturnsCapacity() {
        Assert.assertEquals(5, excavation.getCapacity());
    }


    @Test
    public void addArchaeologistAddsArchaeologist() {
        Archaeologist archaeologist3 = new Archaeologist("archaeologist3", 20);
        excavation.addArchaeologist(archaeologist3);
        Assert.assertEquals(3, excavation.getCount());
        Assert.assertTrue(excavation.removeArchaeologist("archaeologist3"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addArchaeologistToFullExcavationThrowsException() {
        excavation.addArchaeologist(new Archaeologist("archaeologist3", 20));
        excavation.addArchaeologist(new Archaeologist("archaeologist4", 20));
        excavation.addArchaeologist(new Archaeologist("archaeologist5", 20));
        excavation.addArchaeologist(new Archaeologist("archaeologist6", 20));
        excavation.addArchaeologist(new Archaeologist("archaeologist7", 20));
        excavation.addArchaeologist(new Archaeologist("archaeologist8", 20));
    }


    @Test(expected = IllegalArgumentException.class)
    public void addExistingArchaeologistThrowsException() {
        excavation.addArchaeologist(new Archaeologist("archaeologist1", 15));
    }


    @Test
    public void removeArchaeologistRemovesArchaeologistAndReturnsTrue() {
        Assert.assertTrue(excavation.removeArchaeologist("archaeologist1"));
        Assert.assertEquals(1, excavation.getCount());
    }

    @Test
    public void removeArchaeologistReturnsFalseWhenNonExistingArchaeologistNameIsPassed() {
        Assert.assertFalse(excavation.removeArchaeologist("nonExistingArchaeologist"));
        Assert.assertEquals(2, excavation.getCount());
    }


    @Test(expected = IllegalArgumentException.class)
    public void creatingExcavationWithCapacityBelowZeroThrowsException() {
        new Excavation("excavation2", -1);
    }



    @Test(expected = NullPointerException.class)
    public void creatingExcavationWithNullForNameThrowsException() {
        new Excavation(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void creatingExcavationWithWhitespaceNameThrowsException() {
        new Excavation("   ", 10);
    }
}
