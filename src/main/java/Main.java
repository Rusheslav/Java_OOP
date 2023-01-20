import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        ArrayList<BaseHero> heroesOne = new ArrayList<>();
        ArrayList<BaseHero> heroesTwo = new ArrayList<>();
        String[] names = {"Михаил", "Александр", "Пётр", "Андрей", "Илья",
                "Заурбек", "Селиван", "Олег", "Поликарп", "Яков", "Иаков",
                "Антон", "Алексей", "Андрей", "Алек", "Алекс", "Аркадий",
                "Борис", "Бениамин", "Варлам", "Вениамин", "Виктор", "Ванадий",
                "Варис", "Геннадий", "Григорий", "Георгий", "Дмитрий", "Дарий",
                "Даниил", "Данил", "Дан", "Евгений", "Евстратий", "Евтихий"};

        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            int randNum = rand.nextInt(4);
            int randNameNum = rand.nextInt(names.length);
            if (randNum == 0) {
                heroesOne.add(new Peasant(names[randNameNum]));
            } else if (randNum == 1) {
                heroesOne.add(new Rogue(names[randNameNum]));
            } else if (randNum == 2) {
                heroesOne.add(new Sniper(names[randNameNum]));
            } else {
                heroesOne.add(new Mage(names[randNameNum]));
            }
        }
        heroesOne.forEach(n -> System.out.print(n.getInfo() + ", "));
        heroesOne.forEach(n -> n.step(heroesOne));
        heroesOne.forEach(n -> System.out.print(n.getInfo() + ", "));

        System.out.println("\n\n***\n");

        for (int i = 0; i < 10; i++) {
            int randNum = rand.nextInt(4);
            int randNameNum = rand.nextInt(names.length);
            if (randNum == 0) {
                heroesTwo.add(new Peasant(names[randNameNum]));
            } else if (randNum == 1) {
                heroesTwo.add(new Spearman(names[randNameNum]));
            } else if (randNum == 2) {
                heroesTwo.add(new Crossbowman(names[randNameNum]));
            } else {
                heroesTwo.add(new Monk(names[randNameNum]));
            }
        }
        heroesTwo.forEach(n -> System.out.print(n.getInfo() + ", "));
        heroesOne.forEach(n -> n.step(heroesTwo));
        heroesTwo.forEach(n -> System.out.print(n.getInfo() + ", "));
    }

    public static void getHeroes(ArrayList<BaseHero> heroes, String requiredClass) {
        int count = 0;
        for (BaseHero hero : heroes) {
            if (hero.toString().contains(requiredClass)) {
                count++;
                System.out.println(count + ". " + hero);
            }
        }
        if (count == 0) {
            System.out.printf("Персонажей типа %s не нашлось.\n", requiredClass);
        }
    }
}
