package tracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Repository repository = new Repository();

        try (Scanner scanner = new Scanner(System.in)) {

            while (true) { //избавиться от тру
                System.out.println("Введите одно из действий:" +
                        "\n add - Завести новый дефект" +
                        "\n list - Показать перечень дефектов" +
                        "\n change - Изменить статус дефекта" +
                        "\n quit - Выход из программы");

                switch (scanner.nextLine()) {

                    case "add":

                        add(scanner, repository);
                        break;

                    case "change":
                        changeStatus(scanner, repository);
                        break;

                    case "list":
                        for (int i = 0; i < repository.getCounterArray(); i++) {
                            System.out.println(repository.getAll()[i]);
                            System.out.println("________________________");
                        }
                        break;

                    case "quit":
                        System.out.println("Quit");
                        return;

                    default:
                        System.out.println("Возврат в главное меню");
                        break;
                }

            }

        }
    }

    public static void add(Scanner scanner, Repository repository) {
        if (repository.isComplet()) {
            System.out.println("Уже заведено 10 дефектов");
            return;
        }

        System.out.println("Введите резюме по дефекту:");
        String resume = scanner.nextLine();

        System.out.println("Введите критичность дефекта из списка:" + "\n\"trivial\", \"minor\", \"major\", \"blocker\"");
        Critical critical;
        while (true) {
            try {
                critical = Critical.valueOf(scanner.nextLine().toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Введено не корретное значение. Введите повторно критичность дефекта");
            }
        }

        System.out.println("Введите количество дней на исправление:");
        int dayToFix = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Введите для комментария comment или для дефекта id:");
        String attachment = scanner.nextLine();
        switch (attachment) {
            case "comment":
                System.out.println("Введите комментарий:");
                CommentAttachment commentAttachment = new CommentAttachment(scanner.nextLine());
                Defect defect = new Defect(resume, critical, dayToFix, commentAttachment);
                repository.addDefect(defect);
                break;

            case "id":
                System.out.println("Введите id:");
                DefectAttachment defectAttachment = new DefectAttachment(scanner.nextInt());
                scanner.nextLine();
                defect = new Defect(resume, critical, dayToFix, defectAttachment);
                repository.addDefect(defect);
                break;

            default:
                System.out.println("Без комментария");
                defect = new Defect(resume, critical, dayToFix);
                repository.addDefect(defect);
                break;
        }
    }

    public static void changeStatus(Scanner scanner, Repository repository) {
        System.out.println("Введите ID дефекта у которого нужно изменить статус");
        int idDefect = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Введите статус: \n\"open\", \"in_process\", \"test\", \"done\"");

        Status status;

        while (true) {
            try {
                status = Status.valueOf(scanner.nextLine().toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Введено не корретное значение. Введите повторно статус дефекта");
            }
        }

        for (
                Defect defect : repository.getAll()) {
            if (defect.getID() == idDefect) {
                defect.setStatus(status);
            }
        }
    }
}
