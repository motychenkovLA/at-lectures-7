package tracker;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Repository repository = new Repository();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Введите операцию из списка:\nadd - добавить новый дефект; " +
                        "\nchange - именить статус дефекта" + "\nstats - вывести статистику" +
                        "\nlist - вывести список дефектов; \nquit - выход");
                String operation = scanner.nextLine();

                switch (operation) {
                    case "add":
                        writeDefect(scanner, repository);
                        break;

                    case "change":
                        changeStatus(scanner, repository);
                        break;

                    case "list":
                        for (Defect defect : repository.getAll()) {
                            System.out.println(defect);
                            System.out.println("________________________");
                        }
                        break;

                    case "stats":
                        seeStatus(repository);
                        return;

                    case "quit":
                        System.out.println("Выход из системы");
                        return;

                    default:
                        System.out.println("Такой операции не существует\n");
                        break;
                }
            }
        }
    }

    private static void writeDefect(Scanner scanner, Repository repository) {

        System.out.println("Введите описание дефекта");
        String description = scanner.nextLine();

        Severity severity = createSeverity(scanner);

        int amountOfDays = createAmountOfDays(scanner);

        Attachment attachment = createAttachment(scanner);

        Defect defect = new Defect(description, severity, amountOfDays, attachment);
        repository.add(defect);
    }

    private static int createAmountOfDays(Scanner scanner) {
        System.out.println("Дни на исправление дефекта:");
        int amountOfDays = 0;
        while (amountOfDays <= 0) {
            try {
                amountOfDays = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Вводимое значение должно быть числом. Введите еще раз.");
            }
        }
        return amountOfDays;
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

    private static void changeStatus(Scanner scanner, Repository repository) {
        while (true) {
            try {
                System.out.println("Укажите ID дефекта, у которого необходимо изменить статус:");
                long changeId = Long.parseLong(scanner.nextLine());
                Defect def = repository.getById(changeId);
                if (def == null) {
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
                if (Transition.checkTransition(def.getStatus(), to)) {
                    def.setStatus(to);
                } else {
                    System.out.println("Переход в этот статус невозможен");
                    System.out.println("\n");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Не верный формат.");
            }
            break;
        }
    }

    public static void seeStatus(Repository repository) {
        // todo 3 - делается в одно выражение + хардкод всех статусов
        long countOpen = repository.getAll().stream().filter(e -> e.getStatus().equals(Status.OPEN)).count();
        long countInProgress = repository.getAll().stream().filter(e -> e.getStatus().equals(Status.IN_PROGRESS)).count();
        long countRft = repository.getAll().stream().filter(e -> e.getStatus().equals(Status.READY_FOR_TESTING)).count();
        long countTesting = repository.getAll().stream().filter(e -> e.getStatus().equals(Status.TESTING)).count();
        long countDone = repository.getAll().stream().filter(e -> e.getStatus().equals(Status.DONE)).count();
        long countClosed = repository.getAll().stream().filter(e -> e.getStatus().equals(Status.CLOSED)).count();

        // todo 3 - большие повторяющиеся куски в каждом пункте
        int minAmountOfDay = repository.getCountAmountOfDay()
                .stream()
                .mapToInt(Integer::intValue)
                .min().orElse(0);
        int maxAmountOfDay = repository.getCountAmountOfDay()
                .stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
        double averageAmountOfDay = repository.getCountAmountOfDay()
                .stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);

        System.out.println("Максимальное количество дней на исправление: " + maxAmountOfDay + "\n" +
                "Среднее количество дней на исправление: " + averageAmountOfDay + "\n" +
                "Минимальное количество дней на исправление: " + minAmountOfDay + "\n\n" +
                "Статус    |  Количество дефектов в этом статусе\n" +
                "------------------------------------------------\n" +
                "ОТКРЫТ:               | " + countOpen + "\n" +
                "В РАБОТЕ:             | " + countInProgress + "\n" +
                "ГОТОВ К ТЕСТИРОВАНИЮ: | " + countRft + "\n" +
                "ТЕСТИРОВАНИЕ:         | " + countTesting + "\n" +
                "СДЕЛАНО:              | " + countDone + "\n" +
                "ЗАКРЫТ:               | " + countClosed);
    }
}




