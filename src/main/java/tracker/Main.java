package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        final int MAX_CAPACITY = 2;

        Repository allDefects = new Repository(MAX_CAPACITY);

        boolean programRun = true;
        while (programRun) {
            System.out.println("Введите команду:\n\"add\" - добавить новый дефект,\n" +
                    "\"list\" - вывести список дефектов,\n" +
                    "\"quit\" - выйти");
            Scanner scanner = new Scanner(System.in);
            String choiceCommand = scanner.nextLine();

            switch (choiceCommand) {
                case "add":
                    if (!allDefects.isFull()) {

                        System.out.println("Введите описание дефекта");
                        String description = scanner.nextLine();

                        System.out.println("Введите критичность дефекта:\nS1 - Blocker;\nS2 - Critical;" +
                                "\nS3 - Major;\nS4 - Minor;\nS5 - Trivial");
                        String severity = scanner.nextLine();

                        System.out.println("Введите колличество дней для исправления дефекта");
                        int numberOfDays = scanner.nextInt();

                        scanner.nextLine();

                        System.out.println("Выберите тип вложения:\n\"comment\" - ввести комментарий к дефекту,\n" +
                                "\"link\" - ссылка на другой дефект");
                        String choiceAttachment = scanner.nextLine();

                        switch (choiceAttachment) {
                            case "comment":
                                System.out.println("Введите комментарий:");
                                String comment = scanner.nextLine();
                                CommentAttachment commentAttachment = new CommentAttachment(comment);
                                Defect defect1 = new Defect(description, severity, numberOfDays, commentAttachment);
                                allDefects.add(defect1);
                                break;

                            case "link":
                                System.out.println("Введите ссылку на дефект:");
                                int link = scanner.nextInt();
                                DefectAttachment defectAttachment = new DefectAttachment(link);
                                Defect defect2 = new Defect(description, severity, numberOfDays, defectAttachment);
                                allDefects.add(defect2);
                                break;

                            default:
                                System.out.println("Такого типа вложений не существует");
                                break;
                        }

                    } else {
                        System.out.println("Закончилось место!\nВведите другую команде!");
                        continue;
                    }
                    break;
                case "list":

                    Defect[] all = allDefects.getAll();

                    for (int a = 0; a <= (all.length - 1); a++) {
                        System.out.println(all[a].getId() + " | " + all[a].getSummary() + " | " +
                        all[a].getSeverity() + " | " + all[a].getDays() + " | "
                                + all[a].getAttachment().asString());
                    }
                    break;

                case "quit":
                    programRun = false;
                    System.out.println("Пока! Увидимся позже");
                    break;

                default:
                    System.out.println("Неверная команда! Попробуйте снова!");
                    break;
            }
        }
    }
}

