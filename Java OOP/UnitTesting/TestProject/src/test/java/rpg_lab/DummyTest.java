package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTest {

    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int STRONG_DUMMY_HEALTH = 100;
    private static final int DUMMY_EXPERIENCE = 10;
    private static final int DEAD_DUMMY_HEALTH = 0;
    private static final int HERO_EXPECTED_EXPERIENCE = 10;

    private Axe axe;

    @Before
    public void initializeTestObjects(){
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
    }

    @Test
    public void DummyLosesHealthIfAttacked(){
        Axe axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        Dummy dummy = new Dummy(STRONG_DUMMY_HEALTH, DUMMY_EXPERIENCE);

        dummy.takeAttack(axe.getAttackPoints());

        Assert.assertEquals(STRONG_DUMMY_HEALTH - AXE_ATTACK, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowsExceptionIfAttacked(){
        Dummy deadDummy = new Dummy(DEAD_DUMMY_HEALTH, DUMMY_EXPERIENCE);

        deadDummy.takeAttack(this.axe.getAttackPoints());
    }

    @Test
    public void deadDummyCanGiveXP(){
        Hero hero = new Hero("testHero", this.axe);
        Dummy dummy = new Dummy(DEAD_DUMMY_HEALTH + 1, DUMMY_EXPERIENCE);

        hero.attack(dummy);

        Assert.assertTrue(dummy.isDead());
        Assert.assertEquals("Wrong XP", HERO_EXPECTED_EXPERIENCE, hero.getExperience());
    }

    @Test
    public void aliveDummyCantGiveXP(){
        Hero hero = new Hero("testHero", this.axe);
        Dummy dummy = new Dummy(STRONG_DUMMY_HEALTH, DUMMY_EXPERIENCE);

        Assert.assertEquals(" Wrong XP", 0, hero.getExperience());
    }
}
