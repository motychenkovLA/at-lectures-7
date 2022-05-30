package tracker;
import org.jetbrains.annotations.NotNull;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Repository repository = new Repository();
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
                        showList(repository.getAll());
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

    private static void showList(Map<Long,Defect> repository) {
//        for (int a = 0; a <= (repository.length - 1); a++) {
//            System.out.println(repository[a].getId() + " | Описание: " + repository[a].getSummary() +
//                    " | Критичность: " + repository[a].getSeverity() + " | Количество дней для " +
//                    "исправления: " +
//                    repository[a].getDays() + " | " + repository[a].getAttachment().toString() +
//                    " | Статус: " + repository[a].getStatus().ruName);
//        }
        for (Map.Entry<Long, Defect> entry : repository.entrySet()) {
            Defect defect = entry.getValue();
            System.out.println(entry.getKey()  + " | Описание: " + defect.getSummary() +
                    " | Критичность: " + defect.getSeverity() + " | Количество дней для " +
                    "исправления: " + defect.getDays() + " | " + defect.getAttachment().toString() +
                    " | Статус: " + defect.getStatus().ruName);
        }
    }

    private static void changeStatus(Map<Long,Defect> repository, Scanner scanner) {
        long id;
        System.out.println("Введите id дефекта не больше " + (repository.size() - 1));
        boolean runInputId = true;
        while (runInputId) {
            try {
                id = scanner.nextInt();

                if (id < repository.size()) {

                    System.out.println("Введите статус дефекта:\n" +
                            "\"OPEN\" - открыт,\n\"CLOSED\" - закрыт");
                    scanner.nextLine();
                    boolean runInputStatusDefect = true;

                    while (runInputStatusDefect) {
                        try {
                            Defect defect = repository.get(id);
                            defect.setStatus(scanner.nextLine());
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
                System.out.println("Введите значение от 0 до " + (repository.size() - 1)
                        + " включительно");
                scanner.nextLine();
            }
        }
    }
}

