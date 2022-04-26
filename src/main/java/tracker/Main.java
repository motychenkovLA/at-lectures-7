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

        System.out.println("Выберите тип вложения:\n" +
                "-comment\n" +
                "-linkId\n");

        String attachment = scanner.nextLine();
        switch (attachment) {
            case "linkId":
                System.out.println("Введите id дефекта");
                String linkId = scanner.nextLine();
                DefectAttachment defectAttachment = new DefectAttachment(linkId);
                Defect defect = new Defect(description, severity, amountOfDays, defectAttachment);
                repository.add(defect);
                break;

            case "comment":
                System.out.println("Введите комментарий к дефекту");
                String comment = scanner.nextLine();
                CommentAttachment commentAttachment = new CommentAttachment(comment);
                defect = new Defect(description, severity, amountOfDays, commentAttachment);
                repository.add(defect);
                break;
        }
    }
}

