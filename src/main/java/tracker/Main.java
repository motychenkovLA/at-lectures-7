package tracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //    int count = 0;
        Repository repository = new Repository(10);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите одно из действий:" +
                    "\n add - Завести новый дефект" +
                    "\n list - Показать перечень дефектов" +
                    "\n quit - Выход из программы");

            switch (scanner.nextLine()) {

                case "add":

                    add(scanner, repository);
                    break;

                case "change":

                    break;

                case "list":
                    for (Defect r : repository.getAll()) {
                        if (r != null) System.out.println(r.list());
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

    public static void add(Scanner scanner, Repository repository) {
        if (repository.isComplet()) {
            System.out.println("Уже заведено 10 дефектов");
            return;
        }

        System.out.println("Введите резюме по дефекту:");
        String resume = scanner.nextLine();

        System.out.println("Введите критичность дефекта (Низкий, Средний, Высокий, Блокирующий):");
        String critical = scanner.nextLine();

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
}
