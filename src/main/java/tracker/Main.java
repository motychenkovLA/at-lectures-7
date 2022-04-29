package tracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Repository repository = new Repository(10);
        Scanner scanner = new Scanner(System.in);

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

    private static void writeDefect(Scanner scanner, Repository repository) {
        if (repository.isFull()) {
            System.out.println("Не возможно добавить дефект");
            return;
        }

        System.out.println("Введите описание дефекта");
        String description = scanner.nextLine();

        System.out.println("Введите критичность дефекта из списка: \n");
        Severity[] values = Severity.values();
        for (Severity value : values) {
            System.out.println(value);
        }
        Severity severity = Severity.valueOf(scanner.nextLine());


        System.out.println("Дни на исправление дефекта:");
        int amountOfDays = scanner.nextInt();
        scanner.nextLine();

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
                    long linkId = scanner.nextLong();
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
        int change_Id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Изменить статус дефекта на:\n ");
        Status[] values = Status.values();
        for (Status value : values) {
            System.out.println(value);
        }
        Status status = Status.valueOf(scanner.nextLine());

        for (Defect j : repository.getAll()) {
            if (change_Id == j.getId()) {
                j.setStatus(status);
            }
        }
    }
}


