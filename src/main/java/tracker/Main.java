package tracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Repository repository = new Repository(10);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:" +
                    "\n add - Завести дефект" +
                    "\n list - Показать список дефектов" +
                    "\n quit - Выход из программы");

            switch (scanner.nextLine()) {

                case "add":
                    addDefect(scanner, repository);
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
                    System.out.println("Введена неверная команда, возврат в главное меню");
                    break;
            }
        }

    }

    public static void addDefect(Scanner scanner, Repository repository) {
        if (repository.isFull()) {
            System.out.println("Уже заведено 10 дефектов");
            return;
        }

        System.out.println("Введите резюме дефекта:");
        String resume = scanner.nextLine();
        System.out.println("Введите критичность дефекта (Высокая, Средняя, Низкая):");
        String critical = scanner.nextLine();
        System.out.println("Введите срок исправления дефекта, в днях:");
        int dayToRepair = scanner.nextInt();
        System.out.println("выберите тип вложения: комментарий/ссылка");
        scanner.nextLine();
        switch (scanner.nextLine()) {
            case "комментарий":
                System.out.println("Введите комментарий к дефекту");
                CommentAttachment commentAttachment = new CommentAttachment(scanner.nextLine());
                Defect defect = new Defect(resume, critical, dayToRepair, commentAttachment);
                repository.addDefect(defect);
                break;
            case "ссылка":
                System.out.println("введите Id связанного дефекта");
                DefectAttachment defectAttachment = new DefectAttachment(scanner.nextInt());
                scanner.nextLine();
                defect = new Defect(resume, critical, dayToRepair, defectAttachment);
                repository.addDefect(defect);
                break;
            default:
                System.out.println("Некорректное вложение");
                break;
        }

    }

}
