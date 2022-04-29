package tracker;

import java.util.Scanner;

import static tracker.Severity.*;

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

    // todo 1 - private
    public static void writeDefect(Scanner scanner, Repository repository) {
        if (repository.isFull()) {
            System.out.println("Не возможно добавить дефект");
            return;
        }

        System.out.println("Введите описание дефекта");
        String description = scanner.nextLine();

        // todo 3 - дублирование списка существующих значений енама в строке
        System.out.println("Введите критичность дефекта из списка: \n" +
                " BLOCKER \n " +
                "CRITICAL\n " +
                "MAJOR \n" +
                " MINOR\n " +
                "TRIVIAL");

        Severity severity = Severity.valueOf(scanner.nextLine());

        System.out.println("Дни на исправление дефекта:");
        int amountOfDays = scanner.nextInt();
        scanner.nextLine();

        Attachment attachment = createAttachment(scanner);

        Defect defect = new Defect(description, severity, amountOfDays, attachment);
        repository.add(defect);
    }

    // todo 1 - private
    public static Attachment createAttachment(Scanner scanner) {
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
                    scanner.nextLine(); // todo 1 - ?
                    result = new CommentAttachment(comment);
                    break;

                default:
                    System.out.println("Такого типа вложения не существует\n");
                    break;
            }
        }
        return result;
    }

    // todo 1 - private
    public static void changeStatus(Scanner scanner, Repository repository) {
        System.out.println("Укажите ID дефекта, у которого необходимо изменить статус:");
        long change_Id = scanner.nextLong(); // todo 1 - форматирование
        scanner.nextLine();

        // todo 3 - дублирование списка существующих значений енама в строке
        System.out.println("Изменить статус дефекта на:\n " +
                "OPEN\n" +
                "IN_PROGRESS\n" +
                "READY_FOR_TESTING\n" +
                "TESTING\n" +
                "DONE\n" +
                "CLOSED");

        Status status = Status.valueOf(scanner.nextLine());

        for (Defect j : repository.getAll()) {
            if (change_Id == repository.getCounter()) { // todo 5 - если (введенный ид == текущему размеру репо) поменять все дефекты
                j.setStatus(status);
            }
        }
        // todo 3 - лучше достать из репо дефект по его id, а не все что там есть тащить
    }
}


