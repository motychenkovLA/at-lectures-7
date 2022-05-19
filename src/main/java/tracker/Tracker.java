package tracker;

import java.util.Scanner;

public class Tracker {
    public static void main(String[] args) {
        Repository repository = new Repository(10);
        try (Scanner sc = new Scanner(System.in)) {

            while (true) {
                System.out.println("Введите операцию из списка:\n\"add\" - добавить новый дефект\n\"change\" - изменить статус дефекта\n\"list\" - вывести список дефектов\n\"quit\" - выход");
                System.out.println();

                switch (sc.nextLine()) {
                    case "add":
                        addDefect(sc, repository);
                        System.out.println();
                        break;
                    case "change":
                        changeStatus(sc, repository);
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
                        System.out.println("Введена не существующая операция, попробуйте еще раз");
                        System.out.println();
                        break;
                }
            }
        }
    }

    public static void addDefect(Scanner scanner, Repository repository) {
        if (repository.isExamination()) {
            System.out.println("Обращение к индексу больше размера массива, в массиве нет свободного места");
            return;
        }

        System.out.println("Введите резюме дефекта");
        String summary = scanner.nextLine();

        System.out.println("Введите критичность дефекта из списка:" + "\n\"trivial\", \"minor\", \"major\", \"critical\", \"blocker\"");
        Criticality criticality = null;
        while (criticality == null) {
            try {
                criticality = Criticality.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Введена несуществующая критичность, используйте значение из списка");
            }
        }

        System.out.println("Введите количество дней на исправление");
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
                Defect defect = new Defect(summary, criticality, countDay);
                repository.addDef(defect);
            }
            if (choice.equals("Y")) {
                System.out.println("Введите тип вложения из списка: \n\"comment\" - комментарий к дефекту или \"link\" - ссылка к дефекту");
                String attachment = scanner.nextLine();
                switch (attachment) {
                    case "link":
                        System.out.println("Введите id дефекта");
                        DefectAttachment defectAttachment = new DefectAttachment(scanner.nextInt());
                        scanner.nextLine();
                        Defect defect = new Defect(summary, criticality, countDay, defectAttachment);
                        repository.addDef(defect);
                        break;
                    case "comment":
                        System.out.println("Введите комментарий к дефекту");
                        CommentAttachment commentAttachment = new CommentAttachment(scanner.nextLine());
                        defect = new Defect(summary, criticality, countDay, commentAttachment);
                        repository.addDef(defect);
                        break;
                    default:
                        System.out.println("Введена не существующая операция, по умолчанию вложения не будет");
                        defect = new Defect(summary, criticality, countDay);
                        repository.addDef(defect);
                        break;
                }
            }
    }

    public static void changeStatus(Scanner scanner, Repository repository) {
        System.out.println("Введите ID дефекта у которого нужно изменить статус");
        int idDefect = scanner.nextInt();
        scanner.nextLine();
        for (Defect repo :repository.getAll()) {
            if (repo.getID() == idDefect) {
                System.out.println("Выберите статус из списка: \n\"open\", \"in process\", \"test\", \"close\", \"done\"");
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

