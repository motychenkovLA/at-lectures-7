package tracker;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class MainSteps {
    private static int count = 0;
    private static int maxCount = 10;
    private static Repository rep = new Repository(maxCount);
    private static Defect defect;

    public static void caseAdd(Scanner scanner) {
        Severity severity = null;
        int day = 0;
        boolean goodSeverity = false;
        boolean goodDay = false;
        boolean goodId = false;
        if (count < maxCount) {
            System.out.println("Введите резюме дефекта:");
            String summary = scanner.nextLine();

            System.out.println("Введите критичность дефекта: BLOCKER, HIGH, MEDIUM, LOW");
            while (!goodSeverity) {
                try {
                    severity = Severity.valueOf(scanner.nextLine());
                    goodSeverity = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Нет такой критичности, попробуйте еще раз");
                }
            }

            while (!goodDay) {
                try {
                    System.out.println("Введите ожидаемое количество дней на исправление:");
                    day = scanner.nextInt();
                    scanner.nextLine();
                    goodDay = true;
                } catch (NoSuchElementException e) {
                    scanner.nextLine();
                    System.out.println("Введено не число, попробуйте еще раз");
                }
            }
            System.out.println("Введите тип вложения: 1 -комментарий, 2 - ссылка на другой дефект, другой символ - не добавлять вложение");
            String attachType = scanner.nextLine();
            switch (attachType) {
                case "1":
                    System.out.println("Введитие комментарий");
                    String attachComment = scanner.nextLine();
                    defect = new Defect(summary, severity, day, attachComment);
                    break;
                case "2":
                    while (!goodId) {
                        try {
                            System.out.println("Введите ID связанного дефекта");
                            Long attachDefect = scanner.nextLong();
                            scanner.nextLine();
                            defect = new Defect(summary, severity, day, attachDefect);
                            goodId = true;
                        } catch (NoSuchElementException e) {
                            scanner.nextLine();
                            System.out.println("Неверный формать номера, попробуйте еще раз");
                            continue;
                        }
                    }
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

    public static void caseChange(Scanner scanner) {
        boolean goodStatus = false;
        boolean goodId = false;
        Status status = null;
        long id;

        while (!goodId) {
            try {
                System.out.println("Введите ID дефекта");
                id = scanner.nextLong();
                scanner.nextLine();

                if (rep.defectIsFound(id)) goodId = true;

            } catch (NoSuchElementException e) {
                scanner.nextLine();
                System.out.println("Неверный формать номера, попробуйте еще раз");
                continue;
            } catch (MyExeption e) {
                System.out.println("Нет такого дефекта, попробуйте еще раз");
                continue;
            }

            System.out.println("Введите новый статус. Допустимые варианты OPEN, IN_PROGRESS, CLOSED");
            while (!goodStatus) {
                try {

                    status = Status.valueOf(scanner.nextLine());
                    goodStatus = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("попробуйте еще раз");
                    continue;
                }

                for (Defect d1 : rep.getAll()) {
                    if (d1 != null) {
                        if (d1.getId() == id) {
                            d1.changeStatus(status);
                        }
                    }
                }
            }
        }
    }


    public static String chooseAction(Scanner scanner) {
        System.out.println("--------------" + "\n" +
                "Для добавления дефекта введите add" + "\n"
                + "Для вывода списка дефектов введите list" + "\n"
                + "Для изменения статуса дефекта введите change" + "\n"
                + "Для выхода из программы введите quit");
        String choise = scanner.nextLine();
        return choise;

    }


}
