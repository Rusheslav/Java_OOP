import java.util.ArrayList;

public class Healer extends BaseHero {
    Integer mana;
    public Healer (String name, int attack, int defence, int[] damage, int maxHealth, int speed, int mana) {
        super(name, attack, defence, damage, maxHealth, speed);
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
            if (healthShare < minHealth) {
                minHealth = healthShare;
                minHealthInd = i;
            }
        }

        BaseHero weakHero = heroList.get(minHealthInd);
        int wound = weakHero.maxHealth - weakHero.health;
        if (wound <= -this.damage[0]) {
            weakHero.health = maxHealth;
        } else {
            weakHero.health -= this.damage[0];
        }

        System.out.println();
    }
}
