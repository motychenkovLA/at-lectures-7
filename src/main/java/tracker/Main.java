package tracker;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Repository repository = new Repository();
        try (Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.println("Выберите действие:" +
                        "\n add - Завести дефект" +
                        "\n list - Показать список дефектов" +
                        "\n change - сменить статус дефекта" +
                        "\n stats - показать статистику по дефектам" +
                        "\n quit - Выход из программы");

                switch (scanner.nextLine()) {

                    case "add":
                        addDefect(scanner, repository);
                        break;

                    case "list":
                        for (Defect r : repository.getAll()) {
                            if (r != null) System.out.println(r);
                        }
                        break;

                    case "change":
                        changeStatus(scanner, repository);
                        break;

                    case "stats":
                        showStats(repository);
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
    }

    public static void addDefect(Scanner scanner, Repository repository) {
        System.out.println("Введите резюме дефекта:");
        String resume = scanner.nextLine();

        Critical critical = createCritical(scanner);

        int dayToRepair = createDayToRepair(scanner);

        System.out.println("выберите тип вложения: комментарий/ссылка");

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

    private static int createDayToRepair(Scanner scanner) {
        System.out.println("Дни на исправление дефекта:");
        int dayToRepair = 0;
        while (dayToRepair <= 0) {
            try {
                dayToRepair = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Вводимое значение должно быть числом. Введите еще раз.");
            }
        }
        return dayToRepair;
    }

    private static Critical createCritical(Scanner scanner) {
        System.out.println("Введите критичность дефекта из списка: \n");
        Critical[] values = Critical.values();
        Critical critical = null;
        while (critical == null) {
            for (Critical value : values) {
                System.out.println(value);
            }
            try {
                critical = Critical.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Введенная критичность отсутствует в списке. Введите еще раз.");
            }
        }
        return critical;
    }

    public static void showStats (Repository repository) {
            Map<Status, Long> statStatus = repository.getAll().stream().collect(Collectors.groupingBy(Defect::getStatus, Collectors.counting()));
            statStatus.forEach((Status, Long) -> System.out.println("Количество дефектов в статусе " + Status.getRuNameStatus() + " - " + Long));

            IntSummaryStatistics intSummaryStatistics = repository.getAll().stream().collect(Collectors.summarizingInt(Defect::getDayToRepair));
            System.out.println("Максимальное количество дней - " + intSummaryStatistics.getMax() + "\n" + "Минимальное количество дней на исправление - "
                    + intSummaryStatistics.getMin() + "\n" + "Среднее количество дней на исправление - " + intSummaryStatistics.getAverage() + "\n");
        }

    public static void changeStatus(Scanner scanner, Repository repository) {
        while (true) {
            try {
                System.out.println("Введите ID дефекта");
                long defectId = Long.parseLong(scanner.nextLine());
                Defect def = repository.getById(defectId);
                System.out.println("Введите статус дефекта из списка");
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
                        System.out.println("Введенный статус не существует. Попробуйте еще раз.");
                    }
                }
                if (Transition.checkTransition(def.getStatus(), to)) {
                    def.setStatus(to);
                } else {
                    System.out.println("Перевод в данный статус не соответствует жизненному циклу дефекта."
                            + "Введите другой статус");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Не верный формат.");
            }
            break;
        }
    }
}


