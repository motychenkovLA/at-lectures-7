package tracker;

import java.util.*;

public class MainSteps {
    private static Repository rep = new Repository();
    private static Defect defect;

    public static void caseAdd(Scanner scanner) {
        Severity severity = null;
        int day = 0;
        boolean goodSeverity = false;
        boolean goodDay = false;
        boolean goodId = false;
        boolean goodComment = false;

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
                while (!goodComment) {
                    try {
                        System.out.println("Введитие комментарий");

                        CommentAttachment attachComment = new CommentAttachment(scanner.nextLine());
                        defect = new Defect(summary, severity, day, attachComment);
                        goodComment = true;
                    } catch (Exception e) {
                        System.out.println("Что-то пошло не так, введите комментарий еще раз");
                    }
                }
                break;
            case "2":
                while (!goodId) {
                    try {
                        System.out.println("Введите ID связанного дефекта");
                        DefectAttachment attachDefect = new DefectAttachment(scanner.nextLong());
                        scanner.nextLine();
                        defect = new Defect(summary, severity, day, attachDefect);
                        goodId = true;
                    } catch (NoSuchElementException e) {
                        scanner.nextLine();
                        System.out.println("Неверный формать номера, попробуйте еще раз");
                    }
                }
                break;
            default:
                defect = new Defect(summary, severity, day);
                break;
        }
        rep.addDefect(defect);
    }

    public static void caseList() {

        for (Map.Entry<Long, Defect> entry : rep.getAll().entrySet()) {
            System.out.println(entry.getValue().toString());
        }
    }

    public static void caseChange(Scanner scanner) {
        boolean goodStatus = false;
        boolean goodId = false;
        Status status;
        long id;
        Map<Long, Defect> defects;

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

            System.out.println("Введите новый статус: OPEN, IN_PROGRESS, IN_TESTING, CLOSED");
            while (!goodStatus) {
                try {

                    status = Status.valueOf(scanner.nextLine());
                    goodStatus = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("попробуйте еще раз");
                    continue;
                }
                defects = rep.getAll();
                if (defects.containsKey(id) && defects.get(id).checkTransition(defects.get(id).getStatus(), status)) {
                    defects.get(id).changeStatus(status);
                } else System.out.println("такое изменение статуса запрещено");
            }
        }
    }

    public static void caseStats() {
        rep.getStatistic();
    }

    public static String chooseAction(Scanner scanner) {
        System.out.println("--------------" + "\n" +
                "Для добавления дефекта введите add" + "\n"
                + "Для вывода списка дефектов введите list" + "\n"
                + "Для изменения статуса дефекта введите change" + "\n"
                + "Для просмотра статистики введите stats" + "\n"
                + "Для выхода из программы введите quit");
        String choise = scanner.nextLine();
        return choise;

    }


}
