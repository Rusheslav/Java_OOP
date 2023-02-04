package Units;

import java.util.ArrayList;
import java.util.Random;

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
        if (health > 0) {
            if (mana == 1) {
                double minHealth = 1.0;
                int minHealthInd = 0;
                for (int i = 0; i < name.size(); i++) {
                    BaseHero hero = name.get(i);
                    double healthShare = (double) hero.health / (double) hero.maxHealth;
                    if (healthShare < minHealth) {
                        minHealth = healthShare;
                        minHealthInd = i;
                    }
                }

                BaseHero weakHero = name.get(minHealthInd);
                if (weakHero.health > 0) {
                    float wound = (float) weakHero.maxHealth - weakHero.health;
                    if (wound <= -this.damage[0]) {
                        weakHero.health = weakHero.maxHealth;
                    } else {
                        weakHero.health -= this.damage[0];
                    }
                } else {
                    if (type.equals("Monk")) {
                        switch (new Random().nextInt(4)) {
                            case 0:
                                name.set(minHealthInd, new Peasant(name, weakHero.getPosition().x, weakHero.getPosition().y, gangSize));
                                break;
                            case 1:
                                name.set(minHealthInd, new Rogue(name, weakHero.getPosition().x, weakHero.getPosition().y, gangSize));
                                break;
                            case 2:
                                name.set(minHealthInd, new Sniper(name, weakHero.getPosition().x, weakHero.getPosition().y, gangSize));
                                break;
                            default:
                                name.set(minHealthInd, new Monk(name, weakHero.getPosition().x, weakHero.getPosition().y, gangSize));
                                break;
                        }
                    } else {
                        switch (new Random().nextInt(4)) {
                            case 0:
                                name.set(minHealthInd, new Peasant(name, weakHero.getPosition().x, weakHero.getPosition().y, gangSize));
                                break;
                            case 1:
                                name.set(minHealthInd, new Spearman(name, weakHero.getPosition().x, weakHero.getPosition().y, gangSize));
                                break;
                            case 2:
                                name.set(minHealthInd, new Crossbowman(name, weakHero.getPosition().x, weakHero.getPosition().y, gangSize));
                                break;
                            default:
                                name.set(minHealthInd, new Mage(name, weakHero.getPosition().x, weakHero.getPosition().y, gangSize));
                                break;
                        }
                    }
                    mana = 0;
                }
            } else {
                mana = 1;
            }
        }
    }
}
