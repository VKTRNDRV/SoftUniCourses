package rpg_lab;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class HeroTests {

    private static final int DUMMY_EXPERIENCE = 10;
    private static final int AXE_ATTACK = 10;

    @Test
    public void attackGainsXPIfTargetIsDead(){
        Target targetMock = Mockito.mock(Target.class);
        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveExperience()).thenReturn(DUMMY_EXPERIENCE);


        Weapon weaponMock = Mockito.mock(Weapon.class);

        Hero hero = new Hero("testHero", weaponMock);
        hero.attack(targetMock);
        Assert.assertEquals("Wrong XP", DUMMY_EXPERIENCE, hero.getExperience());
    }
}
