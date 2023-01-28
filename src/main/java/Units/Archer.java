package Units;

import java.util.ArrayList;

public class Archer extends BaseHero {
    Integer shoots;
    public Archer(ArrayList<BaseHero> name, int attack, int defence, int[] damage, int maxHealth, int speed, int shoots, int x, int y) {
        super(name, attack, defence, damage, maxHealth, speed, x, y);
        this.shoots = shoots;
    }

    @Override
    public String toString() {
        return super.toString() + ", Shoots " + shoots;
    }

    @Override
    public void step(ArrayList<BaseHero> heroList) {
        for (BaseHero hero : heroList) {
            if (hero.supply == 1) {
                hero.supply = 0;
                this.shoots += 1;
                break;
            }
        }
        if (this.shoots > 0) {
            this.shoots -= 1;
        } else {
            System.out.println("\nСтрел нет");
        }
    }

    @Override
    public String getInfo() {
        String outStr = String.format("⚔ %d\t\uD83D\uDEE1 %d\t♥%d%%\t☠%d\t➵%d", attack,defence,health * 100/maxHealth,(damage[0] + damage[1])/2,shoots);
        return outStr;
    }
}
