package tracker;

import org.jetbrains.annotations.NotNull;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int MAX_CAPACITY = 2;
        Repository repository = new Repository(MAX_CAPACITY);
        boolean programRun = true;
        try(Scanner scanner = new Scanner(System.in)) {
            while (programRun) {
                menu();
                String choiceCommand = scanner.nextLine();
                switch (choiceCommand) {
                    case "add": {
                        if (!repository.isFull()) {
                            System.out.println("Введите описание дефекта");
                            String description = scanner.nextLine();
                            Severity severity = Severity.valueOf("TRIVIAL");
                            severity = inputSeverity(severity);
                            int numberOfDays = 0;
                            numberOfDays = inputNumberOfDays(numberOfDays);
                            System.out.println("Выберите тип вложения:\n\"comment\" - ввести комментарий " +
                                    "к дефекту,\n\"link\" - ссылка на другой дефект");
                            String choiceAttachment;
                            boolean runChooseAttachment = true;
                            while (runChooseAttachment) {
                                choiceAttachment = scanner.nextLine();
                                switch (choiceAttachment) {
                                    case "comment":
                                        Defect defect1 = new Defect(description,
                                                severity.ruName, numberOfDays, inputCommentAttachment());
                                        repository.add(defect1);
                                        runChooseAttachment = false;
                                        break;
                                    case "link":
                                        Defect defect2 = new Defect(description, severity.ruName,
                                                numberOfDays, inputLinkAttachment());
                                        repository.add(defect2);
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
                    }
                    case "list": {
                        Defect[] all = repository.getAll();
                        showList(all);
                        break;
                    }
                    case "change": {
                        Defect[] massiveWithDefects = repository.getAll();
                        changeStatus(massiveWithDefects);
                        break;
                    }
                    case "quit": {
                        programRun = false;
                        System.out.println("Пока! Увидимся позже");
                        break;
                    }
                    default: {
                        System.out.println("Неверная команда! Попробуйте снова!");
                        break;
                    }
                }
            }
        }
    }

    public static void menu() {
        System.out.println("Введите команду:\n\"add\" - добавить новый дефект,\n" +
                "\"list\" - вывести список дефектов,\n" + "\"change\" - изменить статус дефекта,\n" +
                "\"quit\" - выйти");
    }

    public static Severity inputSeverity(Severity severity) {
        System.out.println("Введите критичность дефекта:\nBLOCKER (блокирующий);\nCRITICAL" +
                " (критический);" +
                "\nMAJOR (значительный);\nMINOR (незначительный);\nTRIVIAL (тривиальный)");
        boolean runInputSeverity = true;
        while (runInputSeverity) {
            try {
                Scanner scanner = new Scanner(System.in);
                severity = Severity.valueOf(scanner.nextLine());
                runInputSeverity = false;
            } catch (IllegalArgumentException e) {
                System.out.println("Неверное значение. Введите значение из списка");
            }
        }
        return severity;
    }

    public static int inputNumberOfDays(int number) {
        System.out.println("Введите колличество дней для исправления дефекта");
        boolean runInputNumberOfDays = true;
        while (runInputNumberOfDays) {

            try {
                Scanner scanner = new Scanner(System.in);
                number = scanner.nextInt();
                runInputNumberOfDays = false;

            } catch (InputMismatchException y) {

                System.out.println("Неверное значение. Нужно вводить число.");
                System.out.println("Попробуйте ещё раз");
            }
        }
        return number;
    }

    public static @NotNull CommentAttachment inputCommentAttachment() {
        System.out.println("Введите комментарий:");
        Scanner scanner = new Scanner(System.in);
        String comment = scanner.nextLine();
        return new CommentAttachment(comment);
    }

    public static DefectAttachment inputLinkAttachment() {
        boolean runInputLink = true;
        int link;
        DefectAttachment linkAttachment = null;
        Scanner scanner = new Scanner(System.in);
        while (runInputLink) {
            System.out.println("Введите ссылку на дефект:");
            try {
                link = scanner.nextInt();
                linkAttachment = new DefectAttachment(link);
                scanner.nextLine();
                runInputLink = false;

            } catch (InputMismatchException y) {
                System.out.println("Введено некорректное значение!");
                System.out.println("Попробуйте ещё раз!");
                scanner.nextLine();
            }
        }

        return linkAttachment;
    }

    public static void showList(Defect @NotNull [] repository) {
        for (int a = 0; a <= (repository.length - 1); a++) {
            System.out.println(repository[a].getId() + " | Описание: " + repository[a].getSummary() +
                    " | Критичность: " + repository[a].getSeverity() + " | Количество дней для " +
                    "исправления: " +
                    repository[a].getDays() + " | " + repository[a].getAttachment().toString() +
                    " | Статус: " + repository[a].getStatus().ruName);
        }
    }

    public static void changeStatus(Defect @NotNull []  repository) {
        int id;
        boolean runInputId = true;
        System.out.println("Введите id дефекта от 0 до " + (repository.length - 1));
        Scanner scanner = new Scanner(System.in);
        while (runInputId) {

            try {
                id = scanner.nextInt();

                if (id < repository.length) {

                    System.out.println("Введите статус дефекта:\n" +
                            "\"OPEN\" - открыт,\n\"CLOSED\" - закрыт");
                    scanner.nextLine();
                    boolean runInputStatusDefect = true;

                    while (runInputStatusDefect) {
                        try {
                            repository[id].setStatus(scanner.nextLine());
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

            } catch (InputMismatchException i) {
                System.out.println("Введите значение от 0 до " + (repository.length - 1)
                        + " включительно");
                scanner.nextLine();
            }
        }
    }
}

