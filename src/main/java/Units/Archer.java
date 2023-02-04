package Units;

import java.util.ArrayList;

public class Archer extends BaseHero {
    Integer shoots;
    public Archer(ArrayList<BaseHero> name, int attack, int defence, int[] damage, int maxHealth, int speed, int shoots, int x, int y, int gangSize) {
        super(name, attack, defence, damage, maxHealth, speed, x, y, gangSize);
        this.shoots = shoots;
    }

    @Override
    public String toString() {
        return super.toString() + ", Shoots " + shoots;
    }

    @Override
    public void step(ArrayList<BaseHero> heroList) {
        if (health > 0) {
            BaseHero target = getTarget(heroList);
            if (target.health == 0) {
                System.out.println("Они все мертвы, милорд!");
            } else {
                float distToTarget = getPosition().getDistance(target.getPosition().x, target.getPosition().y);
                float minDist = gangSize - 1;
                float maxDist = (float) Math.sqrt((gangSize - 1) * (gangSize - 1) + (gangSize - 1) * (gangSize - 1));
                float attackPower = (maxDist - distToTarget) / (maxDist - minDist);
                float actualDamage = attackPower * (damage[1] - damage[0]) + damage[0];

                for (BaseHero hero : heroList) {
                    if (hero.supply == 1) {
                        hero.supply = 0;
                        this.shoots += 1;
                        break;
                    }
                }
                if (this.shoots > 0) {
                    this.shoots -= 1;
                    target.health -= actualDamage;
                    if (target.health < 0) {
                        target.health = 0;
                    }
                } else {
                    System.out.println("\nСтрел нет");
                }
            }
        }
    }

    private BaseHero getTarget(ArrayList<BaseHero> heroList) {
        BaseHero target = heroList.get(0);
        float minDist = getPosition().getDistance(target.getPosition().x, target.getPosition().y);
        for (BaseHero hero: heroList) {
            float distance = getPosition().getDistance(hero.getPosition().x, hero.getPosition().y);
            if (distance < minDist && hero.health > 0) {
                target = hero;
                minDist = distance;
            } else if (target.health == 0 && hero.health > 0) {
                target = hero;
                minDist = distance;
            }
        }
        return target;
    }

    @Override
    public String getInfo() {
        String outStr = String.format("\t%-3s\t⚔ %-3d\t\uD83D\uDEE1 %-3d\t♥%-3d%%\t☠%-3d\t➵%-3d\t", type, attack,defence,(int) health * 100/maxHealth,(damage[0] + damage[1])/2,shoots);
        return outStr;
    }
}
