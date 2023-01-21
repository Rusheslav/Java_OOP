import Units.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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

        ArrayList<BaseHero> sortedArmyOne = sortArmy(heroesOne);
        ArrayList<BaseHero> sortedArmyTwo = sortArmy(heroesTwo);

        Scanner scan = new Scanner(System.in);
        boolean startApp = true;
        while (startApp) {
            if (scan.nextLine().contains("exit")) {
                startApp = false;
            } else {
                sortedArmyOne.forEach(n -> System.out.print(n.getInfo() + ", "));
                sortedArmyOne.forEach(n -> n.step(sortedArmyOne));

                System.out.println("\n***");

            }
        }
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

    public static ArrayList<BaseHero> sortArmy(ArrayList<BaseHero> heroes) {
        ArrayList<BaseHero> resArray = new ArrayList<>();
        for (BaseHero hero : heroes) {
            if (hero.getInfo().contains("Monk") || hero.getInfo().contains("Mage")) {
                resArray.add(hero);
            }
        }
        for (BaseHero hero : heroes) {
            if (!(hero.getInfo().contains("Peasant") || hero.getInfo().contains("Monk") || hero.getInfo().contains("Mage"))) {
                resArray.add(hero);
            }
        }
        for (BaseHero hero : heroes) {
            if (hero.getInfo().contains("Peasant")) {
                resArray.add(hero);
            }
        }
        return resArray;
    }

}


