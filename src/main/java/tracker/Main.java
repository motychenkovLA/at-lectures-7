package tracker;

// todo 0 - лишний импорт
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Repository repository = new Repository(10);

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Введите операцию из списка:\nadd - добавить новый дефект; " +
                        "\nchange - именить статус дефекта" + "\nlist - вывести список дефектов; \nquit - выход");
                String operation = scanner.nextLine();

                switch (operation) {
                    case "add":
                        writeDefect(scanner, repository);
                        break;

                    case "change":
                        changeStatus(scanner, repository);
                        break;

                    case "list":
                        for (Defect i : repository.getAll()) {
                            System.out.println(i);
                            System.out.println("________________________");
                        }
                        break;

                    case "quit":
                        System.out.println("Выход из системы");
                        return;

                    default:
                        System.out.println("Такой операции не существует\n");
                        break;
                }
            }
        }
    }

    private static void writeDefect(Scanner scanner, Repository repository) {
        if (repository.isFull()) {
            System.out.println("Не возможно добавить дефект");
            return;
        }

        System.out.println("Введите описание дефекта");
        String description = scanner.nextLine();

        Severity severity = createSeverity(scanner);

        int amountOfDays = createAmountOfDays(scanner);

        Attachment attachment = createAttachment(scanner);

        Defect defect = new Defect(description, severity, amountOfDays, attachment);
        repository.add(defect);
    }

    private static int createAmountOfDays(Scanner scanner) {
        System.out.println("Дни на исправление дефекта:");
        int amountOfDays = 0;
        while (amountOfDays <= 0) {
            try {
                amountOfDays = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Вводимое значение должно быть числом. Введите еще раз.");
            }
        }
        return amountOfDays;
    }

    private static Severity createSeverity(Scanner scanner) {
        System.out.println("Введите критичность дефекта из списка: \n");
        Severity[] values = Severity.values();
        Severity severity = null;

        while (severity == null) {
            for (Severity value : values) {
                System.out.println(value);
            }
            try {
                severity = Severity.valueOf(scanner.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println("Введенная критичность отсутствует в списке. Введите еще раз.");
            }
        }
        return severity;
    }

    private static Attachment createAttachment(Scanner scanner) {
        Attachment result = null;

        while (result == null) {
            System.out.println("Выберите тип вложения:\n" +
                    "-comment\n" +
                    "-linkId\n");
            String attachment = scanner.nextLine();

            switch (attachment) {
                case "linkId":
                    System.out.println("Введите id дефекта");
                    long linkId = 0;
                    while (true) {
                        try {
                            linkId = Long.parseLong(scanner.nextLine());
                            result = new DefectAttachment(linkId);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Не верный формат. Введите еще раз.");
                        }
                    }
                    break;
                case "comment":
                    System.out.println("Введите комментарий к дефекту");
                    String comment = scanner.nextLine();
                    result = new CommentAttachment(comment);
                    break;

                default:
                    System.out.println("Такого типа вложения не существует\n");
                    break;
            }
        }
        return result;
    }

    private static void changeStatus(Scanner scanner, Repository repository) {
        long changeId = 0; // todo 3 - а вдруг существует дефект с id 0 ?
        while (repository.getById(changeId) == null) {
            System.out.println("Укажите ID дефекта, у которого необходимо изменить статус:");
            try {
                changeId = Long.parseLong(scanner.nextLine());
                if (repository.getById(changeId) == null) {
                    System.out.println("Дефекта с таким id не существует");
                }

            } catch (NumberFormatException e) {
                System.out.println("Не верный формат. Введите еще раз.");
            }
        }

        System.out.println("Изменить статус дефекта на:\n ");
        Status[] values = Status.values();
        Status status = null;

        while (status == null) {
            for (Status value : values) {
                System.out.println(value);
            }
            try {
                status = Status.valueOf(scanner.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println("Введенный статус отсутствует в списке. Введите еще раз.");
            }
        }
        repository.getById((int) changeId).setStatus(status); // todo 1 - changeId преобразуется в int хотя метод принимает long
    }
}




