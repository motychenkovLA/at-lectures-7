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
                printMenu();
                String choiceCommand = scanner.nextLine();
                switch (choiceCommand) {
                    case "add": {
                        if (!repository.isFull()) {
                            add(repository, scanner);
                        } else {
                            System.out.println("Закончилось место!\nВведите другую команду!");
                        }
                        break;
                    }
                    case "list": {
                        Defect[] all = repository.getAll();
                        showList(all);
                        break;
                    }
                    case "change": {
                        changeStatus(repository.getAll(), scanner);
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

    private static void add(Repository repository, Scanner scanner) {
        System.out.println("Введите описание дефекта");
        String description = scanner.nextLine();
        Severity severity = Severity.valueOf("TRIVIAL");
        severity = inputSeverity(severity, scanner);
        int numberOfDays = 0;
        numberOfDays = inputNumberOfDays(numberOfDays, scanner);
        System.out.println("Выберите тип вложения:\n\"comment\" - ввести комментарий " +
                "к дефекту,\n\"link\" - ссылка на другой дефект");
        scanner.nextLine();
        String choiceAttachment;
        boolean runChooseAttachment = true;
        while (runChooseAttachment) {
            choiceAttachment = scanner.nextLine();
            switch (choiceAttachment) {
                case "comment": {
                    Defect defect1 = new Defect(description,
                            severity.ruName, numberOfDays, inputCommentAttachment(scanner));
                    repository.add(defect1);
                    runChooseAttachment = false;
                    break;
                }
                case "link": {
                    Defect defect2 = new Defect(description, severity.ruName,
                            numberOfDays, inputLinkAttachment(scanner));
                    repository.add(defect2);
                    runChooseAttachment = false;
                    break;
                }
                default: {
                    System.out.println("Такого типа вложений не существует");
                    break;
                }
            }
        }
    }

    private static void printMenu() {
        System.out.println("Введите команду:\n\"add\" - добавить новый дефект,\n" +
                "\"list\" - вывести список дефектов,\n" + "\"change\" - изменить статус дефекта,\n" +
                "\"quit\" - выйти");
    }

    private static Severity inputSeverity(Severity severity, Scanner scanner) {
        System.out.println("Введите критичность дефекта:\nBLOCKER (блокирующий);\nCRITICAL" +
                " (критический);" +
                "\nMAJOR (значительный);\nMINOR (незначительный);\nTRIVIAL (тривиальный)");
        boolean runInputSeverity = true;
        while (runInputSeverity) {
            try {
                severity = Severity.valueOf(scanner.nextLine());
                runInputSeverity = false;
            } catch (IllegalArgumentException e) {
                System.out.println("Неверное значение. Введите значение из списка");
            }
        }
        return severity;
    }

    private static int inputNumberOfDays(int number, Scanner scanner) {
        System.out.println("Введите колличество дней для исправления дефекта");
        boolean runInputNumberOfDays = true;
        while (runInputNumberOfDays) {

            try {
                number = scanner.nextInt();
                runInputNumberOfDays = false;

            } catch (InputMismatchException y) {

                System.out.println("Неверное значение. Нужно вводить число.");
                System.out.println("Попробуйте ещё раз");
            }
        }
        return number;
    }

    private static @NotNull CommentAttachment inputCommentAttachment(Scanner scanner) {
        System.out.println("Введите комментарий:");
        String comment = scanner.nextLine();
        return new CommentAttachment(comment);
    }

    private static DefectAttachment inputLinkAttachment(Scanner scanner) {
        boolean runInputLink = true;
        int link;
        DefectAttachment linkAttachment = null;
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

    private static void showList(Defect @NotNull [] repository) {
        for (int a = 0; a <= (repository.length - 1); a++) {
            System.out.println(repository[a].getId() + " | Описание: " + repository[a].getSummary() +
                    " | Критичность: " + repository[a].getSeverity() + " | Количество дней для " +
                    "исправления: " +
                    repository[a].getDays() + " | " + repository[a].getAttachment().toString() +
                    " | Статус: " + repository[a].getStatus().ruName);
        }
    }

    private static void changeStatus(Defect @NotNull [] repository, Scanner scanner) {
        int id;
        boolean runInputId = true;
        System.out.println("Введите id дефекта от 0 до " + (repository.length - 1));
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

