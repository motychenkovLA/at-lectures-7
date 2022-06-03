package tracker;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Repository repository = new Repository();

        try (Scanner scanner = new Scanner(System.in)) {

            while (true) {
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
{
                            System.out.println(repository.getAllDefect());
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
        Set<Transition> set = new HashSet<>();
        Collections.addAll(set, new Transition(Status.OPEN, Status.IN_PROCESS),
                new Transition(Status.IN_PROCESS, Status.TEST),
                new Transition(Status.TEST, Status.DONE));

        System.out.println("Введите ID дефекта у которого нужно изменить статус");
        long idDefect = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Введите статус: \n\"open\", \"in_process\", \"test\", \"done\"");
        Status to;
        while (true) {
            try {
                to = Status.valueOf(scanner.nextLine().toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Введено не корретное значение. Введите повторно статус дефекта");
            }
        }
        try {
            if (set.contains(new Transition(repository.getById(idDefect).getStatus(), to)))
                repository.getById(idDefect).setStatus(to);
            else System.out.println("Не корректная смена статуса");
        } catch (NullPointerException e) {
            System.out.println("Не существует дефекта с таким id");
        }
    }
}
