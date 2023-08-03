package magicGame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MagicianTests {

    private Magician magician;

    @Before
    public void setUp(){
        this.magician = new Magician("username1", 100);
    }



    // getUsername returns username
    @Test
    public void testGetUsernameReturnsUsername(){
        Assert.assertEquals("username1", magician.getUsername());
    }


    // create Magician and setUsername sets username
    @Test
    public void testSetUsernameSetsUsername() {
        magician = new Magician("newUsername", 100);
        Assert.assertEquals("newUsername", magician.getUsername());
    }

    // create magician setUsername null throws NullPointerException
    @Test(expected = NullPointerException.class)
    public void testSetUsernameNullThrowsNullPointerException() {
        magician = new Magician(null, 100);
    }

    // create magician setUsername whitespace throws NullPointerException
    @Test(expected = NullPointerException.class)
    public void testSetUsernameWhitespaceThrowsNullPointerException() {
        magician = new Magician("     ", 100);
    }

    // getHealth returns health
    @Test
    public void testGetHealthReturnsHealth() {
        Assert.assertEquals(100, magician.getHealth());
    }


    // create magician setHealth sets health
    @Test
    public void testSetHealthSetsHealth() {
        magician = new Magician("m2", 150);
        Assert.assertEquals(150, magician.getHealth());
    }

    // create magician setHealth below zero throws IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testSetHealthBelowZeroThrowsIllegalArgumentException() {
        new Magician("m3", -10);
    }


    // getMagics returns magics
    @Test
    public void testGetMagicsReturnsMagics() {
        Assert.assertNotNull(magician.getMagics());
    }

    // getMagics returned collection cannot be modified
    @Test(expected = UnsupportedOperationException.class)
    public void testGetMagicsUnmodifiable() {
        magician.getMagics().add(new Magic("Magic Test", 10));
    }

    // takeDamage reduces health
    @Test
    public void testTakeDamageReducesHealth() {
        magician.takeDamage(50);
        Assert.assertEquals(50, magician.getHealth());
    }

    // takeDamage on death magician throws IllegalStateException
    @Test(expected = IllegalStateException.class)
    public void testTakeDamageOnDeathThrowsIllegalStateException() {
        magician.takeDamage(100);
        magician.takeDamage(10); // This should throw an exception since the magician is already dead.
    }

    // takeDamage enough to kill sets damage to zero
    @Test
    public void testTakeDamageEnoughToKillSetsDamageToZero() {
        magician.takeDamage(150); // Taking more damage than health to make sure it sets to zero.
        Assert.assertEquals(0, magician.getHealth());
    }


    // addMagic adds magic
    @Test
    public void testAddMagicAddsMagic() {
        Magic magic = new Magic("Test Magic", 20);
        magician.addMagic(magic);
        Assert.assertTrue(magician.getMagics().contains(magic));
    }

    // addMagic null throws NullPointerException
    @Test(expected = NullPointerException.class)
    public void testAddMagicNullThrowsNullPointerException() {
        magician.addMagic(null);
    }


    // removeMagic removes magic
    @Test
    public void testRemoveMagicRemovesMagic() {
        Magic magic = new Magic("Test Magic", 20);
        magician.addMagic(magic);
        Assert.assertTrue(magician.removeMagic(magic));
        Assert.assertFalse(magician.getMagics().contains(magic));
    }

    // removeMagic remove non-existing element returns false
    @Test
    public void testRemoveNonExistingMagicReturnsFalse() {
        Magic magic = new Magic("Test Magic", 20);
        Assert.assertFalse(magician.removeMagic(magic));
    }


    // getMagic returns magic
    @Test
    public void testGetMagicReturnsMagic() {
        Magic magic = new Magic("Test Magic", 20);
        magician.addMagic(magic);
        Assert.assertEquals(magic, magician.getMagic("Test Magic"));
    }

    // getMagic non-existing magic returns null
    @Test
    public void testGetNonExistingMagicReturnsNull() {
        Assert.assertNull(magician.getMagic("Non-existing Magic"));
    }
}
