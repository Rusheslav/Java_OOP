package Units;

import java.util.ArrayList;

public class Soldier extends BaseHero {
    public Soldier(ArrayList<BaseHero> name, int attack, int defence, int[] damage, int maxHealth, int speed, int x, int y) {
        super(name, attack, defence, damage, maxHealth, speed, x, y);
    }

    @Override
    public void step(ArrayList<BaseHero> heroList) {

    }
}
