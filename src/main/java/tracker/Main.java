package tracker;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static String choise;
    private static int count = 0;
    private static int maxCount = 10;
    private static Repository rep = new Repository(maxCount);
    private static Defect defect;

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
                    break;
                }
                case "change": {
                    caseChange();
                    break;
                }
            }
        }
        while (!choise.equals("quit"));
    }

    public static void caseAdd() {
        if (count < maxCount) {
            System.out.println("Введите резюме дефекта:");
            String summary = scanner.nextLine();
            System.out.println("Введите критичность дефекта: 1- блокирующий, 2 - высокий, 3 - средний, другой символ - низкий");
            SeverityList severity;
            switch (scanner.nextLine()) {
                case "1":
                    severity = SeverityList.BLOCKER;
                    break;
                case "2":
                    severity = SeverityList.HIGH;
                    break;
                case "3":
                    severity = SeverityList.MEDIUM;
                    break;
                default:
                    severity = SeverityList.LOW;
                    break;
            }
            System.out.println("Введите ожидаемое количество дней на исправление:");
            int day = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Введите тип вложения: 1 -комментарий, 2 - ссылка на другой дефект, другой символ - не добавлять вложение");
            String attachType = scanner.nextLine();
            switch (attachType) {
                case "1":
                    System.out.println("Введитие комментарий");
                    String attachComment = scanner.nextLine();
                    defect = new Defect(summary, severity, day, attachComment);
                    break;
                case "2":
                    System.out.println("Введите ID связанного дефекта");
                    Long attachDefect = scanner.nextLong();
                    scanner.nextLine();
                    defect = new Defect(summary, severity, day, attachDefect);
                    break;
                default:
                    defect = new Defect(summary, severity, day);
                    break;
            }
            rep.addDefect(defect);
            count++;
        } else System.out.println("Зарегистрировано максимально возможное количество дефектов");
    }

    public static void caseList() {
        for (Defect d1 : rep.getAll()) {
            if (d1 != null) {
                System.out.println(d1.toString());
            }
        }
    }

    public static void caseChange() {
        System.out.println("Введите ID дефекта");
        long id = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Введите новый статус: 1 - Открыто, 2 - В работе, 3 - Закрыто");
        StatusList status = null;
        switch (scanner.nextLine()) {
            case "1":
                status = StatusList.OPEN;
                break;
            case "2":
                status = StatusList.IN_PROGRESS;
                break;
            case "3":
                status = StatusList.CLOSED;
                ;
                break;
            default:
                System.out.println("Нет такого статуса");
                ;
                return;  //если выбран неверный статус, выполняется возврат из метода
        }
        if (rep.defectIsFound(id)) {
            for (Defect d1 : rep.getAll()) {
                if (d1 != null) {
                    if (d1.getId() == id) {
                        d1.changeStatus(status);
                    }
                }
            }
        } else System.out.println("Дефект не найден");
    }

    public static void chooseAction() {
        System.out.println("--------------" + "\n" +
                "Для добавления дефекта введите add" + "\n"
                + "Для вывода списка дефектов введите list" + "\n"
                + "Для изменения статуса дефекта введите change" + "\n"
                + "Для выхода из программы введите quit");
        choise = scanner.nextLine();
    }


}
