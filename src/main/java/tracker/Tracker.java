package tracker;

import java.util.*;

public class Tracker {
    public static void main(String[] args) {
        Repository repository = new Repository();
        try (Scanner sc = new Scanner(System.in)) {

            while (true) {
                System.out.println("Введите операцию из списка:\n\"add\" - добавить новый дефект\n\"change\" - изменить статус дефекта\n\"list\" - вывести список дефектов" +
                        "\n\"stats\" - статистика по дефектам\n\"quit\" - выход");
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
                            System.out.println(repository.getAllDefect());
                            System.out.println("________________________");
                        break;
                    case "stats":
                            stats(repository);
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

        System.out.println("Введите резюме дефекта");
        String summary = scanner.nextLine();

        System.out.println("Введите критичность дефекта из списка:");
        Criticality[] cr = Criticality.values();
        for (Criticality criticality1 : cr) {
            System.out.print("\"" + criticality1.getName() + "\"" + " ");
        }
        System.out.println();

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
            }else if (choice.equals("Y")) {
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
            } else {
                System.out.println("Введена не существующая операция, по умолчанию вложения не будет");
                Defect defect = new Defect(summary, criticality, countDay);
                repository.addDef(defect);
            }
    }

    public static void changeStatus(Scanner scanner, Repository repository) {
        Set <Transition> set = new HashSet<>();
        Collections.addAll(set, new Transition(Status.OPEN, Status.IN_PROCESS),
                new Transition(Status.OPEN, Status.TEST), new Transition(Status.IN_PROCESS, Status.TEST),
                new Transition(Status.IN_PROCESS, Status.CLOSE), new Transition(Status.TEST, Status.DONE),
                new Transition(Status.TEST, Status.DONE), new Transition(Status.TEST, Status.CLOSE));

        System.out.println("Введите ID дефекта у которого нужно изменить статус");
        Long idDef = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Выберите статус из списка: \n\"open\", \"in_process\", \"test\", \"close\", \"done\"");
        Status to;
        while (true) {
            try {
                to = Status.valueOf(scanner.nextLine().toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Введен несуществующий статус, используйте значение из списка");
            }
        }

        try {
            if (set.contains(new Transition(repository.getById(idDef).getStatus(), to))) {
                repository.getById(idDef).setStatus(to);
            } else {
                System.out.println("Невалидное перемещение");
            }
        } catch (NullPointerException e) {
            System.out.println("Введен несуществующий ID дефекта");
        }
    }

    public static void stats(Repository repository) {
        long countOpen = repository.getAllDefect().stream()
                .filter(e -> e.getStatus().equals(Status.OPEN)).count();
        long countTest = repository.getAllDefect().stream()
                .filter(e -> e.getStatus().equals(Status.TEST)).count();
        long countProcess = repository.getAllDefect().stream()
                .filter(e -> e.getStatus().equals(Status.IN_PROCESS)).count();
        long countClose = repository.getAllDefect().stream()
                .filter(e -> e.getStatus().equals(Status.CLOSE)).count();
        long countDone = repository.getAllDefect().stream()
                .filter(e -> e.getStatus().equals(Status.DONE)).count();


        int maxDay = repository.getAllDefect().stream()
                .mapToInt(Defect ::getCountDay)
                .max()
                .orElse(0);

        int minDay = repository.getAllDefect().stream()
                .mapToInt(Defect ::getCountDay)
                .max()
                .orElse(0);

//        Defect maxDay = repository.getAllDefect().stream()
//                .max(Comparator.comparingInt(Defect::getCountDay))
//                .get();

        double statistics = repository.getAllDefect().stream()
                .mapToInt(Defect ::getCountDay)
                .summaryStatistics()
                .getAverage();


//        int maxDay = repository.getCounterDay().stream()
//                .max(Integer ::compareTo)
//                .orElse(0);
//
//        int minDay = repository.getCounterDay().stream()
//                .mapToInt(Integer ::intValue)
//                .min()
//                .orElse(0);
//
//        double average = repository.getCounterDay().stream()
//                .mapToInt(Integer ::intValue)
//                .average()
//                .orElse(0.0);

        System.out.println("Максимальное колич. дней на работу: " + maxDay
                + ", \nМиниимальное колич. дней на работу: " + minDay
                + ", \nСреднее количество дней на исправление: " + statistics
                + ", \nДефекты со статусом Открыто: "+countOpen + ", Дефекты со статусом Тестирование: " + countTest
                + ", \nДефекты со статусом В работе: "+countProcess + ", Дефекты со статусом Выполненно: "+countDone
                + ", \nДефекты со статусом Закрыто: "+countClose);

//        System.out.println();
    }
}

