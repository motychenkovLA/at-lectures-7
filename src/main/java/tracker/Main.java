package tracker;

// todo 0 - не используемые импорты
import java.lang.reflect.Array;
import java.util.Arrays;
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

        // todo 1 - ввод критичности довольно большой теперь лучше вынести в отдельный метод как с аттачментом
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

        // todo 1 - ввод дней тоже довольно большой теперь, лучше вынести в метод
        System.out.println("Дни на исправление дефекта:");
        int amountOfDays = 0;
        while (amountOfDays <= 0) {
            try {
                amountOfDays = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Вводимое значение должно быть числом. Введите еще раз.");
            }
        }

        Attachment attachment = createAttachment(scanner);

        Defect defect = new Defect(description, severity, amountOfDays, attachment);
        repository.add(defect);
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
                    long linkId = scanner.nextLong(); // todo 3 - может упасть на неформатном числе
                    scanner.nextLine();
                    result = new DefectAttachment(linkId);
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
        System.out.println("Укажите ID дефекта, у которого необходимо изменить статус:");
        long changeId = scanner.nextLong(); // todo 3 - может упасть на неформатном лонге
        scanner.nextLine();

        // todo 3 - уже есть id, лучше сразу проверить вдруг он не валидный и не просить новый статус тогда

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

        repository.getById((int) changeId).setStatus(status);
    }
}




