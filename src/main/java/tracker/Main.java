package tracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Repository repository = new Repository(10);

        while (true) {
            System.out.println("Выберите действие:\n" + "Добавить новый дефект - add, Вывести список - list, " +
                    "Выйти из программы - quit");

            switch (scanner.nextLine()) {
                case "add":
                    addDefect(scanner, repository);
                    break;

                case "list":
                    for (Defect x : repository.getAll()) {
                        System.out.println(x.info());
                        System.out.println("_____________________________________________________________________");
                    }
                    break;

                case "quit":
                    System.out.println("Выход из программы");
                    return;

                default:
                    System.out.println("try again");
                    System.out.println();
                    break;
            }
        }
    }

    public static void addDefect(Scanner scanner, Repository repository) {
        if (repository.isFull()) {
            System.out.println("Размер дефектов превышен");
            return;
        }

        System.out.println("//Создание баг-репорта//");
        System.out.println("Введите название дефекта");
        String name = scanner.nextLine();

        System.out.println("Введите критичность дефекта:\n" + "(trivial, minor, major, critical, blocker)");
        String critical = scanner.nextLine();

        System.out.println("Введите ожидаемое кол-во дней на исправление дефекта");
        int countDay = scanner.nextInt();
        scanner.nextLine();

        Attachment attachment = createAttachment(scanner);

        Defect defect = new Defect(name, critical, countDay, attachment);
        repository.add(defect);
    }

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
                    result = new CommentAttachment(comment);
                    break;

                default:
                    System.out.println("Такого типа вложения не существует\n");
                    break;
            }
        }
        return result;
    }
}