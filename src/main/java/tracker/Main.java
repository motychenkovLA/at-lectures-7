package tracker;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static String choise;
    private static int count = 0;
    private static int maxCount = 10;
    private static Repository rep = new Repository(maxCount);

    public static void main(String[] args) {
        do {
            chooseAction();
            switch (choise) {
                case "add": {
                    caseAdd();
                    break;
                }
                case "list": {
                    caseList();
                }
            }
        }
        while (!choise.equals("quit"));

    }

    public static void caseAdd() {
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
    }

    public static void caseList() {
            for (Defect d1 : rep.getAll()) {
                if (d1 != null) {
                    System.out.println(d1.getId() + " | " + d1.getSummary() + " | " + d1.getSeverity() + " | " + d1.getDay());
                }
            }

    }

    public static void chooseAction(){
        System.out.println("--------------" + "\n" +
                "Для добавления дефекта введите add" + "\n"
                + "Для вывода списка дефектов введите list" + "\n"
                + "Для выхода из программы введите quit");
        choise = scanner.nextLine();
    }
}
