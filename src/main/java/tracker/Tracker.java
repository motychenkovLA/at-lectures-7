package tracker;

import java.util.Scanner;

public class Tracker {
    public static void main(String[] args) {
        Repository repository = new Repository(10);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Введите операцию из списка:\nadd - добавить новый дефект\nlist - вывести список дефектов\nquit - выход");
            System.out.println();

            switch (sc.nextLine()) {
                case "add":
                    addDefect(sc, repository);
                    System.out.println();
                    break;
                case "list":
                    for (int i = 0; i < repository.getCounterArray(); i++) {
                        System.out.println(repository.getAll()[i]);
                        System.out.println("________________________");
                    }
                    break;
                case "quit":
                    System.out.println("Выход из системы");
                    return;
                default:
                    System.out.println("Введена не существующая операция");
                    System.out.println();
            }
        }
    }

    public static void addDefect(Scanner scanner, Repository repository) {
        if (repository.isExamination()) {
            System.out.println("Обращение к индексу больше размера массива");
            return;
        }

        System.out.println("Введите резюме дефекта");
        String summary = scanner.nextLine();

        System.out.println("Введите критичность дефекта из списка:" + "\ntrivial, minor, major, critical, blocker");
        String criticality = scanner.nextLine();
        if (criticality.equals("trivial") || criticality.equals("minor") || criticality.equals("major") ||
                criticality.equals("critical") || criticality.equals("blocker")) {
            criticality = criticality;
        } else {
            criticality = "minor";
        }

        System.out.println("Введите количество дней на исправление");
        int countDay = scanner.nextInt();
        scanner.nextLine();
        if (countDay <= 0) {
            countDay = 1;
        }

        System.out.println("Хотите добавить вложение Y, да/N, нет?");
        String choice = scanner.nextLine();
        if (choice.equals("N")) {
            Defect defect = new Defect(summary, criticality, countDay);
            repository.addDef(defect);
            return;
        }
        if (choice.equals("Y")) {
            System.out.println("Введите тип вложения из списка: \n\"Comment\" - комментарий к дефекту или \"Link\" - ссылка к дефекту");
            String attachment = scanner.nextLine();
            switch (attachment) {
                case "Link":
                    System.out.println("Введите id дефекта");
                    DefectAttachment defectAttachment = new DefectAttachment(scanner.nextInt());
                    scanner.nextLine();
                    Defect defect = new Defect(summary, criticality, countDay,  defectAttachment);
                    repository.addDef(defect);
                    break;
                case "Comment":
                    System.out.println("Введите комментарий к дефекту");
                    CommentAttachment commentAttachment = new CommentAttachment(scanner.nextLine());
                    defect = new Defect(summary, criticality, countDay, commentAttachment);
                    repository.addDef(defect);
                    break;
                default:
                    System.out.println("Введена не существующая операция, дефект не добавлен в систему");
                    return;
            }
        }
    }
}

