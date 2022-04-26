package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String choise;
        int count = 0;
        int maxCount = 10;
        Repository rep = new Repository(maxCount);

        do {
            System.out.println("--------------" + "\n" +
                    "Для добавления дефекта введите add" + "\n"
                    + "Для вывода списка дефектов введите list" + "\n"
                    + "Для выхода из программы введите quit");
            choise = scanner.nextLine();
            switch (choise) {

                case "add": {
                    if (count < maxCount) {

                        System.out.println("Введите резюме дефекта:");
                        String summary = scanner.nextLine();
                        System.out.println("Введите критичность дефекта. Возможные варианты: блокирующий, высокий, средний, низкий");
                        String severity = scanner.nextLine();
                        System.out.println("Введите ожидаемое количество дней на исправление:");
                        int day = scanner.nextInt();
                        scanner.nextLine();

                        Defect defect = new Defect(summary, severity, day);

                        rep.addDefect(defect);

                        count++;
                    } else System.out.println("Зарегистрировано максимально возможное количество дефектов");
                    break;

                }
                case "list": {
                    rep.getAll();
                }
            }

        }
        while (!choise.equals("quit"));

    }


}
