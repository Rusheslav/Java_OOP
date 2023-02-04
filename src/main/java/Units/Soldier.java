package Units;

import java.util.ArrayList;

public class Soldier extends BaseHero {
    public Soldier(ArrayList<BaseHero> name, int attack, int defence, int[] damage, int maxHealth, int speed, int x, int y, int gangSize) {
        super(name, attack, defence, damage, maxHealth, speed, x, y, gangSize);
    }

    @Override
    public void step(ArrayList<BaseHero> heroList) {
        if (health > 0) {
            BaseHero target = getTarget(heroList);
            if (target.health == 0) {
                System.out.println("Они все мертвы, милорд!");
            } else if (getPosition().getDistance(target.getPosition().x, target.getPosition().y) <= 1) {
                target.health = target.health - attack + target.defence;
                if (target.health < 0) {
                    target.health = 0;
                }
            } else {
                float newMinDist = getPosition().getDistance(target.getPosition().x - 1, target.getPosition().y);
                int[] steps = {1, 0};
                if (getPosition().getDistance(target.getPosition().x + 1, target.getPosition().y) < newMinDist) {
                    newMinDist = getPosition().getDistance(target.getPosition().x + 1, target.getPosition().y);
                    steps = new int[]{-1, 0};
                }
                if (getPosition().getDistance(target.getPosition().x, target.getPosition().y - 1) < newMinDist) {
                    newMinDist = getPosition().getDistance(target.getPosition().x, target.getPosition().y - 1);
                    steps = new int[]{0, 1};
                }
                if (getPosition().getDistance(target.getPosition().x, target.getPosition().y + 1) < newMinDist) {
                    steps = new int[]{0, -1};
                }
                getPosition().x += steps[0];
                getPosition().y += steps[1];
            }
        }
    }

    private BaseHero getTarget(ArrayList<BaseHero> heroList) {
        BaseHero target = heroList.get(0);
        float minDist = getPosition().getDistance(target.getPosition().x, target.getPosition().y);
        for (BaseHero hero : heroList) {
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
}