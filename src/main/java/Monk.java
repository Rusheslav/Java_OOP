public class Monk extends BaseHero {
    int mana;
    public Monk(String name, int attack, int defence, int[] damage, int health, int speed, int mana) {
        super(name, attack, defence, damage, health, speed);
        this.mana = mana;
    }

    public Monk(String name) {
        super(name, 17, 12, new int[] {-4, -4}, 30, 5);
        this.mana = 1;
    }

    @Override
    public String toString() {
        return super.toString() + ", Mana";
    }
}
