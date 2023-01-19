import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        ArrayList<BaseHero> heroes = new ArrayList<>();
        String[] names = {"Михаил", "Александр", "Пётр", "Андрей", "Илья",
                "Заурбек", "Селиван", "Олег", "Поликарп", "Яков", "Иаков",
                "Антон", "Алексей", "Андрей", "Алек", "Алекс", "Аркадий",
                "Борис", "Бениамин", "Варлам", "Вениамин", "Виктор", "Ванадий",
                "Варис", "Геннадий", "Григорий", "Георгий", "Дмитрий", "Дарий",
                "Даниил", "Данил", "Дан", "Евгений", "Евстратий", "Евтихий"};

        Random rand = new Random();

        for (int i = 0; i < 50; i++) {
            int randNum = rand.nextInt(7);
            int randNameNum = rand.nextInt(names.length);
            if (randNum == 0) {
                heroes.add(new Peasant(names[randNameNum]));
            } else if (randNum == 1) {
                heroes.add(new Rogue(names[randNameNum]));
            } else if (randNum == 2) {
                heroes.add(new Sniper(names[randNameNum]));
            } else if (randNum == 3) {
                heroes.add(new Mage(names[randNameNum]));
            } else if (randNum == 4) {
                heroes.add(new Spearman(names[randNameNum]));
            } else if (randNum == 5) {
                heroes.add(new Crossbowman(names[randNameNum]));
            } else {
                heroes.add(new Monk(names[randNameNum]));
            }
        }

        for (BaseHero name : heroes) {
            System.out.println(name);
        }
        System.out.println("=========");

        getHeroes(heroes, "Monk");
    }

    public static void getHeroes(ArrayList<BaseHero> heroes, String requiredClass) {
        int count = 0;
        for (BaseHero hero : heroes) {
            if (hero.getClass().getName().equals(requiredClass)) {
                count++;
                System.out.println(count + ". " + hero);
            }
        }
        if (count == 0) {
            System.out.printf("Персонажей типа %s не нашлось.\n", requiredClass);
        }
    }
}
