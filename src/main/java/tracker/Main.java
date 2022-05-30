package tracker;

import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Repository repository = new Repository();
        try (Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.println("Выберите действие:\n" + "Добавить новый дефект - add,\n" +
                        "Изменить статус дефекта - change,\n" + "Вывести статистику - stats,\n" +
                        "Вывести список - list,\n" + "Выйти из программы - quit");
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
                        for (Defect defect : repository.getAll()) {
                            System.out.println(defect);
                            System.out.println("_____________________________________________________________________");
                        }
                        break;

                    case "stats":
                        seeStatusForStatistic(repository);
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

        System.out.println("Введите название дефекта");
        String summary = scanner.nextLine();

        Severity severity = createSeverity(scanner);

        int amountOfDays = createCountDay(scanner);

        Attachment attachment = createAttachment(scanner);

        Defect defect = new Defect(summary, severity, amountOfDays, attachment);
        repository.add(defect);
    }

    private static int createCountDay(Scanner scanner) {
        System.out.println("Дни на исправление дефекта:");
        int countDay = 0;
        while (countDay <= 0) {
            try {
                countDay = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Вводимое значение должно быть числом. Введите еще раз.");
            }
        }
        return countDay;
    }

    private static Severity createSeverity(Scanner scanner) {
        System.out.println("Введите критичность дефекта из списка: \n");
        Severity[] values = Severity.values();
        Severity severity = null;

        while (severity == null) {
            for (Severity value : values) {
                System.out.println(value);
            }
            try {
                severity = Severity.valueOf(scanner.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println("Введенная критичность отсутствует в списке. Введите еще раз.");
            }
        }
        return severity;
    }

    private static Attachment createAttachment(Scanner scanner) {
        Attachment result = null;

        while (result == null) {
            System.out.println("Выберите тип вложения:\n" +
                    "-comment\n" +
                    "-linkId\n");
            String attachment = scanner.nextLine();

            switch (attachment) {
                case "linkId":
                    System.out.println("Введите id дефекта");
                    while (true) {
                        try {
                            long linkId = Long.parseLong(scanner.nextLine());
                            result = new DefectAttachment(linkId);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Не верный формат. Введите еще раз.");
                        }
                    }
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

    public static void changeStatus(Scanner scanner, Repository repository) {

        while (true) {
            try {
                System.out.println("Укажите ID дефекта, у которого необходимо изменить статус:");
                long changeId = Long.parseLong(scanner.nextLine());
                Defect defect = repository.getById(changeId);
                if (defect == null) {
                    System.out.println("Дефекта с таким id не существует");
                    continue;
                }

                System.out.println("Изменить статус дефекта на:\n ");
                Status[] values = Status.values();
                Status to;

                while (true) {
                    for (Status value : values) {
                        System.out.println(value);
                    }
                    try {
                        to = Status.valueOf(scanner.nextLine());
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Введенный статус отсутствует в списке. Введите еще раз.");
                    }
                }

                if (Transition.checkTransition(defect.getStatus(), to)) {
                    defect.setStatus(to);
                } else {
                    System.out.println("Переход в этот статус невозможен, попробуйте еще раз");
                    System.out.println("\n");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Не верный формат.");
            }
            break;
        }
    }

    public static void seeStatusForStatistic(Repository repository) {
        Map<Status, Long> stat = repository.getAll().stream()
                .collect(Collectors.groupingBy(Defect::getStatus, Collectors.counting()));

        stat.forEach((Status, Long) -> System.out.println("Количество дефектов в статусе " + Status.getRuName() +
                " равно " + Long));

        IntSummaryStatistics intSummaryStatistics = repository.getAll()
                .stream().collect(Collectors.summarizingInt(Defect::getCountDay));
        System.out.println("Максимальное количество дней на исправление: " + intSummaryStatistics.getMax() + "\n" +
                "Минимальное количество дней на исправление: " + intSummaryStatistics.getMin() + "\n" +
                "Среднее количество дней на исправление: " + intSummaryStatistics.getAverage() + "\n");
    }
}