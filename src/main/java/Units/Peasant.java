package Units;

import java.util.ArrayList;

public class Peasant extends BaseHero{
    public Peasant(ArrayList<BaseHero> name, int attack, int defence, int[] damage, int maxHealth, int speed, int x, int y) {
        super(name, attack, defence, damage, maxHealth, speed, x, y);
    }

    public Peasant(ArrayList<BaseHero> name, int x, int y) {
        super(name, 1, 1, new int[] {1, 1}, 1, 3, x, y);
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
        if (this.supply == 0) {
            this.supply = 1;
        }
    }

    @Override
    public String getInfo() {
        String outStr = String.format("⚔ %d\t\uD83D\uDEE1 %d\t♥%d%%\t☠%d\t✊%d", attack,defence,health * 100/maxHealth,(damage[0] + damage[1])/2,supply);
        return outStr;
    }
}
