package magicGame.models.magics;

import magicGame.common.ExceptionMessages;

public abstract class MagicImpl implements Magic{

    private String name;
    private int bulletsCount;


    public MagicImpl(String name, int bulletsCount){
        setName(name);
        setBulletsCount(bulletsCount);
    }


    private int bulletsFire;

    protected void setBulletsFire(int bulletsFire) {
        this.bulletsFire = bulletsFire;
    }

    protected void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages
                    .INVALID_MAGIC_NAME);
        }
        this.name = name;
    }

    protected void setBulletsCount(int bulletsCount) {
        if(bulletsCount < 0){
            throw new IllegalArgumentException(ExceptionMessages
                    .INVALID_MAGIC_BULLETS_COUNT);
        }
        this.bulletsCount = bulletsCount;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getBulletsCount() {
        return bulletsCount;
    }

    @Override
    public int fire() {
        if(this.bulletsCount < this.bulletsFire){
            return 0;
        }
        this.bulletsCount -= this.bulletsFire;
        return this.bulletsFire;
    }
}
