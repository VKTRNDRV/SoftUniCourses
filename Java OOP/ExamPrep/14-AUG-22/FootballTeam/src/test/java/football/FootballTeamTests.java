package football;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FootballTeamTests {

    private FootballTeam footballTeam;

    @Before
    public void setUp(){
        this.footballTeam = new FootballTeam("team1", 10);
        footballTeam.addFootballer(new Footballer("footballer1"));
        footballTeam.addFootballer(new Footballer("footballer2"));
    }


    @Test
    public void testGetName() {
        Assert.assertEquals("team1", footballTeam.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameNull() {
        new FootballTeam(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameWhitespace() {
        new FootballTeam("   ", 10);
    }


    @Test
    public void testGetVacantPositions() {
        Assert.assertEquals(10, footballTeam.getVacantPositions());
    }


    @Test(expected = IllegalArgumentException.class)
    public void testSetVacantPositionsBelowZero() {
        new FootballTeam("asdf", -5);
    }


    @Test
    public void testGetCount() {
        Assert.assertEquals(2, footballTeam.getCount());
    }


    @Test
    public void testAddFootballer() {
        footballTeam.addFootballer(new Footballer("footballer3"));
        Assert.assertEquals(3, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddFootballerToFullTeam() {
        FootballTeam team2 = new FootballTeam("team2", 1);
        team2.addFootballer(new Footballer("footballer3"));
        team2.addFootballer(new Footballer("footballer4")); // This should throw an exception
    }


    @Test
    public void testRemoveFootballer() {
        footballTeam.removeFootballer("footballer1");
        Assert.assertEquals(1, footballTeam.getCount());
    }


    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFootballerNonExistingName() {
        footballTeam.removeFootballer("footballer20"); // This footballer doesn't exist in the team
    }


    @Test
    public void testFootballerForSale() {
        Footballer footballer = footballTeam.footballerForSale("footballer1");
        Assert.assertFalse(footballer.isActive());
    }


    @Test(expected = IllegalArgumentException.class)
    public void testFootballerForSaleNonExistingName() {
        footballTeam.footballerForSale("footballer5"); // This footballer doesn't exist in the team
    }


    @Test
    public void testGetStatistics() {
        Assert.assertEquals("The footballer footballer1, footballer2 is in the team team1.", footballTeam.getStatistics());
    }

}
