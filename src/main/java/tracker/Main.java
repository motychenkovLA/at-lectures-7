package tracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Repository repository = new Repository(10);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите операцию из списка:\nadd - добавить новый дефект; " +
                    "\nlist - вывести список дефектов; \nquit - выход");
            String operation = scanner.nextLine();

            switch (operation) {
                case "add":
                    writeDefect(scanner, repository);
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

    public static void writeDefect(Scanner scanner, Repository repository) {
        if (repository.isFull()) {
            System.out.println("Не возможно добавить дефект");
            return;
        }

        System.out.println("Введите описание дефекта");
        String description = scanner.nextLine();

        System.out.println("Выберите кричтичность дефектов из:\n" +
                "-Blocker\n" +
                "-Critical\n" +
                "-Major\n" +
                "-Minor\n" +
                "-Trivial\n");
        String severity = scanner.nextLine();

        System.out.println("Дни на исправление дефекта:");
        int amountOfDays = scanner.nextInt();
        scanner.nextLine();

        Attachment attachment = createAttachment(scanner);

        Defect defect = new Defect(description, severity, amountOfDays, attachment);
        repository.add(defect);
    }

    public static Attachment createAttachment(Scanner scanner) {
        System.out.println("Выберите тип вложения:\n" +
                "-comment\n" +
                "-linkId\n");
        String attachment = scanner.nextLine();

        Attachment result = null;

        // todo 3 - всё ещё пропускает невалидный ввод + сейчас с невалидным типо аттача создает невалидный дефект.
        //  нужно просить у пользователя тип пока не получим валидный
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
                scanner.nextLine();
                result = new CommentAttachment(comment);
                break;

            default:
                System.out.println("Такого типа вложения не существует\n");
                break;
        }

        return result;
    }
}

