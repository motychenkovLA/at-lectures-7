package tracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Repository repository = new Repository(10);
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Выберите действие:\n" + "Добавить новый дефект - add,\n" +
                        "Изменить статус дефекта - change,\n" + "Вывести список - list,\n" +
                        "Выйти из программы - quit");
                String operation = scanner.nextLine();

                switch (operation) {
                    case "add":
                        addDefect(scanner, repository);
                        System.out.println();
                        break;

                    case "change":
                        changeStatus(scanner, repository);
                        System.out.println();
                        break;

                    case "list":
                        for (int i = 0; i < repository.getCapacity(); i++) {
                            System.out.println(repository.getAll()[i]);
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
    }

    public static void addDefect(Scanner scanner, Repository repository) {
        if (repository.isFull()) {
            System.out.println("Размер дефектов превышен");
            return;
        }

        System.out.println("Введите название дефекта");
        String name = scanner.nextLine();

        System.out.println("Введите критичность дефекта из списка:"
                + "\n\"trivial\", \"minor\", \"major\", \"critical\", \"blocker\"");
        Severity severity = null;
        while (severity == null) {
            try {
                severity = Severity.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Введена несуществующая критичность, используйте значение из списка");
            }
        }

        System.out.println("Введите ожидаемое кол-во дней на исправление дефекта");
        int countDay = 0;
        while (countDay == 0) {
            try {
                countDay = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Некорректный формат данных, введите целое число");
            }
        }
        if (countDay <= 0) {
            countDay = 1;
        }

        System.out.println("Хотите добавить вложение Y, да/N, нет?");
        String choice = scanner.nextLine();
        if (choice.equals("N")) {
            Defect defect = new Defect(name, severity, countDay);
            repository.add(defect);
        }
        if (choice.equals("Y")) {
            System.out.println("Введите тип вложения из списка: " +
                    "\n\"comment\" - комментарий к дефекту или \"link\" - ссылка к дефекту");
            String attachment = scanner.nextLine();

            switch (attachment) {
                case "linkId":
                    System.out.println("Введите id дефекта");
                    DefectAttachment defectAttachment = new DefectAttachment(scanner.nextInt());
                    scanner.nextLine();
                    Defect defect = new Defect(name, severity, countDay, defectAttachment);
                    repository.add(defect);
                    break;
                case "comment":
                    System.out.println("Введите комментарий к дефекту");
                    CommentAttachment commentAttachment = new CommentAttachment(scanner.nextLine());
                    defect = new Defect(name, severity, countDay, commentAttachment);
                    repository.add(defect);
                    break;
                default:
                    System.out.println("Введена не существующая операция, по умолчанию вложения не будет");
                    defect = new Defect(name, severity, countDay);
                    repository.add(defect);
                    break;
            }
        }
    }
    public static void changeStatus(Scanner scanner, Repository repository) {
        System.out.println("Укажите ID дефекта, у которого необходимо изменить статус:");
        int idDefect = scanner.nextInt();
        scanner.nextLine();
        for (Defect repo :repository.getAll()) {
            if (repo.getID() == idDefect) {
                System.out.println("Выберите статус из списка: " +
                        "\n\"open\", \"in process\", \"test\", \"close\", \"done\"");
                Status status = null;
                while (status == null) {
                    try {
                        status = Status.valueOf(scanner.nextLine().toUpperCase());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Введен несуществующий статус, используйте значение из списка");
                    }
                }
                repo.setStatus(status);
            } else {
                System.out.println("Введен несуществующий ID, используйте дефекты которые есть в БД");
                break;
            }
        }
    }
}