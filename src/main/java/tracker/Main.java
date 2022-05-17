package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int MAX_COUNT = 10;
        Repository repository = new Repository(MAX_COUNT);
        try (Scanner scanner = new Scanner(System.in)) {
            boolean isRun = true;
            while (isRun) {
                System.out.println("Выберите действие: " + "\n" + "add - добавить новый дефект" + "\n" +
                        "change - изменить статус" + "\n" + "list - вывести список" + "\n" + "quit - выйти из " +
                        "программы");
                switch (scanner.nextLine()) {
                    case "add": {
                        if (repository.isFull()) {
                            try {
                                System.out.println("Введите резюме дефекта");
                                String resume = scanner.nextLine();
                                System.out.println("Введите критичность дефекта (BLOCKER, CRITICAL, MAJOR, MINOR, " +
                                        "TRIVIAL)");
                                Severity severity = Severity.valueOf(scanner.nextLine());
                                System.out.println("Введите ожидаемое количество дней на исправление дефекта");
                                int daysToFix = Integer.parseInt(scanner.nextLine());
                                System.out.println("Выберите тип вложения: comment - коментарий, link - ссылка " +
                                        "на другой дефект");
                                switch (scanner.nextLine()) {
                                    case "comment": {
                                        System.out.println("Введите комментарий");
                                        String comment = scanner.nextLine();
                                        CommentAttachment commentAttachment = new CommentAttachment(comment);
                                        Defect defect = new Defect(resume, severity, daysToFix, commentAttachment,
                                                Status.OPEN);
                                        repository.add(defect);
                                        break;
                                    }
                                    case "link": {
                                        boolean addLink = true;
                                        while (addLink) {
                                            try {
                                                System.out.println("Введите ID дефекта");
                                                long link = Long.parseLong(scanner.nextLine());
                                                DefectAttachment defectAttachment = new DefectAttachment(link);
                                                Defect defect = new Defect(resume, severity, daysToFix,
                                                        defectAttachment, Status.OPEN);
                                                repository.add(defect);
                                                addLink = false;
                                            } catch (NumberFormatException e) {
                                                System.out.println("Введите число!");
                                            }
                                        }
                                        break;
                                    }
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Введите число!");
                            } catch (IllegalArgumentException e) {
                                System.out.println("Неверное значение! Выберите значение из списка.");
                            }
                        } else {
                            System.out.println("Нельзя ввести больше 10 дефектов!");
                        }
                        break;
                    }

                    case "change": {
                        boolean isChanging = true;
                        while (isChanging) {
                            try {
                                System.out.println("Введите id дефекта");
                                long defectID = Long.parseLong(scanner.nextLine());
                                System.out.println("Выберите новый статус (OPEN, FIXING, TESTING, CLOSED, REJECTED)");
                                Status status = Status.valueOf(scanner.nextLine());
                                for (int i = 0; i < repository.getCurrentDefectNum(); i++) {
                                    if (i + 1 == defectID) {
                                        repository.getAll()[i].setStatus(status);
                                    }
                                }
                                isChanging = false;
                            } catch (NumberFormatException e) {
                                System.out.println("Введите число!");
                            } catch (IllegalArgumentException e) {
                                System.out.println("Неверное значение! Выберите значение из списка: OPEN, FIXING, " +
                                        "TESTING, CLOSED, REJECTED");
                            }
                        }
                        break;
                    }

                    case "list": {
                        System.out.println("Список дефектов:");
                        for (int i = 0; i < repository.getCurrentDefectNum(); i++) {
                            System.out.println("ID: " + repository.getAll()[i].getID() + " | Резюме: " +
                                    repository.getAll()[i].getResume() + " | Критичность: " +
                                    repository.getAll()[i].getSeverity() + " | Дни: " +
                                    repository.getAll()[i].getDaysToFix() + " | Статус: " +
                                    repository.getAll()[i].getStatus() + " | Вложение: " +
                                    repository.getAll()[i].getAttachment().toString());

                        }
                        break;
                    }

                    case "quit": {
                        isRun = false;
                        break;
                    }
                    default: {
                        System.out.println("Введено неверное значение, попробуйте еще раз.");
                        break;
                    }
                }
            }
        }
    }
}


