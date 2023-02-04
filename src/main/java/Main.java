import Units.*;

import java.util.*;

public class Main {
    public static final int GANG_SIZE = 10;
    public static ArrayList<BaseHero> whiteSide;
    public static ArrayList<BaseHero> darkSide;
    public static ArrayList<BaseHero> allUnits;

    public static void main(String[] args) {
        init();

        Scanner scanner = new Scanner(System.in);
        while (true){
            ConsoleView.view();
            makeStep();
            scanner.nextLine();
        }
    }

    private static void init(){
        whiteSide = new ArrayList<>();
        darkSide = new ArrayList<>();
        allUnits = new ArrayList<>();

        int x = 1;
        int y = 1;
        for (int i = 0; i < GANG_SIZE; i++) {
            switch (new Random().nextInt(4)) {
                case 0: whiteSide.add(new Peasant(whiteSide, x, y++, GANG_SIZE)); break;
                case 1: whiteSide.add(new Rogue(whiteSide, x, y++, GANG_SIZE)); break;
                case 2: whiteSide.add(new Sniper(whiteSide, x, y++, GANG_SIZE)); break;
                default: whiteSide.add(new Monk(whiteSide, x, y++, GANG_SIZE)); break;
            }
        }

        x = GANG_SIZE;
        y = 1;
        for (int i = 0; i < GANG_SIZE; i++) {

            switch (new Random().nextInt(4)) {
                case 0: darkSide.add(new Peasant(darkSide, x, y++, GANG_SIZE)); break;
                case 1: darkSide.add(new Spearman(darkSide, x, y++, GANG_SIZE)); break;
                case 2: darkSide.add(new Crossbowman(darkSide, x, y++, GANG_SIZE)); break;
                default: darkSide.add(new Mage(darkSide, x, y++, GANG_SIZE)); break;
            }
        }

        allUnits.addAll(whiteSide);
        allUnits.addAll(darkSide);

    }
    private static void makeStep() {
        HashSet<Integer> speedRates = new HashSet<>();
        for (BaseHero hero : allUnits) {
            speedRates.add(hero.speed);
        }
        ArrayList<Integer> speeds = new ArrayList<>(speedRates);
        Collections.sort(speeds, Collections.reverseOrder());

        for (int speed:speeds) {
            ArrayList<BaseHero> speedArray = new ArrayList<>();
            for (BaseHero unit : allUnits) {
                if (unit.speed == speed) {
                    speedArray.add(unit);
                }
            }
            Collections.shuffle(speedArray);
            for (BaseHero hero:speedArray) {
                if (hero.name.equals(darkSide)) {
                    hero.step(whiteSide);
                } else {
                    hero.step(darkSide);
                }
//                System.out.println("Персонаж " + hero.type + " со скоростью " + hero.speed + " сделал ход.");
            }
        }
    }
}






























