package tracker;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int MAX_CAPACITY = 2;

        Repository allDefects = new Repository(MAX_CAPACITY);

        boolean programRun = true;
        try(Scanner scanner = new Scanner(System.in)) {
            while (programRun) {
                System.out.println("Введите команду:\n\"add\" - добавить новый дефект,\n" +
                        "\"list\" - вывести список дефектов,\n" + "\"change\" - изменить статус дефекта,\n" +
                        "\"quit\" - выйти");
                String choiceCommand = scanner.nextLine();

                switch (choiceCommand) {
                    case "add":
                        if (!allDefects.isFull()) {

                            System.out.println("Введите описание дефекта");
                            String description = scanner.nextLine();

                            System.out.println("Введите критичность дефекта:\nBLOCKER (блокирующий);\nCRITICAL" +
                                    " (критический);" +
                                    "\nMAJOR (значительный);\nMINOR (незначительный);\nTRIVIAL (тривиальный)");

                            boolean runInputSeverity = true;
                            Severity severity = Severity.valueOf("TRIVIAL");
                            while(runInputSeverity) {
                                try {
                                    severity = Severity.valueOf(scanner.nextLine());
                                    runInputSeverity = false;

                                } catch(IllegalArgumentException e) {
                                    System.out.println("Неверное значение. Введите значение из списка");
                                }
                            }

                            System.out.println("Введите колличество дней для исправления дефекта");

                            int numberOfDays = 0;
                            boolean runInputNumberOfDays = true;
                            while(runInputNumberOfDays) {

                                try {
                                    numberOfDays = scanner.nextInt();
                                    runInputNumberOfDays = false;

                                } catch(InputMismatchException y) {

                                    System.out.println("Неверное значение. Нужно вводить число.");
                                    System.out.println("Попробуйте ещё раз");
                                    scanner.nextLine();
                                }
                            }

                            scanner.nextLine();

                            System.out.println("Выберите тип вложения:\n\"comment\" - ввести комментарий " +
                                    "к дефекту,\n\"link\" - ссылка на другой дефект");
                            String choiceAttachment;

                            boolean runChooseAttachment = true;
                            while(runChooseAttachment) {

                                choiceAttachment = scanner.nextLine();

                                switch (choiceAttachment) {
                                    case "comment":
                                        System.out.println("Введите комментарий:");
                                        String comment = scanner.nextLine();
                                        CommentAttachment commentAttachment = new CommentAttachment(comment);
                                        Defect defect1 = new Defect(description,
                                                        severity.ruName, numberOfDays, commentAttachment);
                                        allDefects.add(defect1);
                                        runChooseAttachment = false;
                                        break;
                                    case "link":
                                        boolean runInputLink = true;
                                        while(runInputLink) {
                                            System.out.println("Введите ссылку на дефект:");
                                            try {
                                                int link = scanner.nextInt();
                                                DefectAttachment defectAttachment = new DefectAttachment(link);
                                                Defect defect2 = new Defect(description, severity.ruName,
                                                        numberOfDays, defectAttachment);
                                                allDefects.add(defect2);
                                                scanner.nextLine();
                                                runInputLink = false;

                                            } catch(InputMismatchException y) {
                                                System.out.println("Введено некорректное значение!");
                                                System.out.println("Попробуйте ещё раз!");
                                                scanner.nextLine();
                                            }
                                        }
                                        runChooseAttachment = false;
                                        break;
                                    default:
                                        System.out.println("Такого типа вложений не существует");
                                        break;
                                }
                            }
                        } else {
                            System.out.println("Закончилось место!\nВведите другую команду!");
                            continue;
                        }
                        break;
                    case "list":

                        Defect[] all = allDefects.getAll();

                        for (int a = 0; a <= (all.length - 1); a++) {
                            System.out.println(all[a].getId() + " | Описание: " + all[a].getSummary() +
                                    " | Критичность: " + all[a].getSeverity() + " | Количество дней для " +
                                    "исправления: " +
                                    all[a].getDays() + " | " + all[a].getAttachment().toString() +
                                    " | Статус: " + all[a].getStatus().ruName);
                            System.out.println(all[a].hashCode());
                        }
                        break;

                    case "change":

                        Defect[] massiveWithDefects = allDefects.getAll();
                        int id;
                        boolean runInputId = true;
                        System.out.println("Введите id дефекта от 0 до " + (massiveWithDefects.length-1));

                        while(runInputId) {

                            try {
                                id = scanner.nextInt();

                                if (id < massiveWithDefects.length) {

                                    System.out.println("Введите статус дефекта:\n" +
                                            "\"OPEN\" - открыт,\n\"CLOSED\" - закрыт");
                                    scanner.nextLine();
                                    boolean runInputStatusDefect = true;

                                    while(runInputStatusDefect) {
                                            try {
                                                massiveWithDefects[id].setStatus(scanner.nextLine());
                                                runInputStatusDefect = false;

                                            } catch (IllegalArgumentException e) {
                                                System.out.println("Такой статус установить нельзя! " +
                                                        "Попробуйте ещё раз!");
                                            }
                                    }
                                } else {
                                    System.out.println("Нет дефекта с таким id");
                                    scanner.nextLine();
                                }

                                runInputId = false;

                            } catch(InputMismatchException i) {
                               System.out.println("Введите значение от 0 до " + (massiveWithDefects.length-1)
                                       + " включительно");
                               scanner.nextLine();
                            }

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
}

