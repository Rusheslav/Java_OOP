package Units;

import java.util.ArrayList;

public class Healer extends BaseHero {
    Integer mana;
    public Healer (ArrayList<BaseHero> name, int attack, int defence, int[] damage, int maxHealth, int speed, int mana, int x, int y, int gangSize) {
        super(name, attack, defence, damage, maxHealth, speed, x, y, gangSize);
        this.mana = mana;
    }

    @Override
    public String toString() {
        return super.toString() + ", Mana";
    }

    @Override
    public void step(ArrayList<BaseHero> heroList) {
        double minHealth = 1.0;
        int minHealthInd = 0;
        for (int i = 0; i < heroList.size(); i++) {
            BaseHero hero = heroList.get(i);
            double healthShare = (double) hero.health / (double) hero.maxHealth;
            if (healthShare < minHealth && hero.health > 0) {
                minHealth = healthShare;
                minHealthInd = i;
            }
        }

        BaseHero weakHero = heroList.get(minHealthInd);
        float wound = (float) weakHero.maxHealth - weakHero.health;
        if (wound <= -this.damage[0]) {
            weakHero.health = weakHero.maxHealth;
        } else {
            weakHero.health -= this.damage[0];
        }
    }
}
