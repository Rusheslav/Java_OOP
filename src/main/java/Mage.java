public class Mage extends BaseHero {
    Integer mana;
    public Mage(String name, int attack, int defence, int[] damage, int health, int speed, int mana) {
        super(name, attack, defence, damage, health, speed);
        this.mana = mana;
    }

    public Mage(String name) {
        super(name, 17, 12, new int[] {-5, -5}, 30, 9);
        this.mana = 1;
    }

    @Override
    public String toString() {
        return super.toString() + ", Mana";
    }

}
