package Units;

import java.util.ArrayList;

public class Peasant extends BaseHero{
    public Peasant(ArrayList<BaseHero> name, int attack, int defence, int[] damage, int maxHealth, int speed, int x, int y, int gangSize) {
        super(name, attack, defence, damage, maxHealth, speed, x, y, gangSize);
    }

    public Peasant(ArrayList<BaseHero> name, int x, int y, int gangSize) {
        super(name, 1, 1, new int[] {1, 1}, 1, 3, x, y, gangSize);
        this.supply = 1;
    }

    @Override
    public String toString() {
        if (this.supply == 1) {
            return super.toString() + ", Supply";
        } else {
            return super.toString();
        }
    }

    @Override
    public void step(ArrayList<BaseHero> heroList) {
        if (this.supply == 0 && this.health > 0) {
            this.supply = 1;
        }
    }

    @Override
    public String getInfo() {
        String outStr = String.format("\t%-3s\t⚔ %-3d\t\uD83D\uDEE1 %-3d\t♥%-3d%%\t☠%-3d\t✊%-2d\t", type, attack,defence,(int) health * 100/maxHealth,(damage[0] + damage[1])/2,supply);
        return outStr;
    }
}
