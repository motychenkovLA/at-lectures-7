package tracker;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Repository repository = new Repository();
        try (Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.println("Выберите действие:\n" + "Добавить новый дефект - add,\n" +
                        "Изменить статус дефекта - change,\n" + "Вывести список - list,\n" +
                        "Выйти из программы - quit");
                System.out.println();

                switch (scanner.nextLine()) {
                    case "add":
                        addDefect(scanner, repository);
                        System.out.println();
                        break;

                    case "change":
                        changeStatus(scanner, repository);
                        System.out.println();
                        break;

                    case "list":
                        for (HashMap.Entry<Long, Defect> entry : repository.getAll().entrySet()) {
                            System.out.println(entry.getValue());
                            System.out.println("_____________________________________________________________________");
                        }
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
                    long linkId = 0; // todo 1 - объявлен заранее
                    while (true) {
                        try {
                            linkId = Long.parseLong(scanner.nextLine());
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
            // todo 3 - сет собирается на каждой итерации, Main занимается валидацией, что не его ответственность
            Set<Transition> set = new LinkedHashSet<>();
            Collections.addAll(set, new Transition(Status.OPEN, Status.IN_PROGRESS),
                    new Transition(Status.OPEN, Status.READY_FOR_TESTING),
                    new Transition(Status.IN_PROGRESS, Status.READY_FOR_TESTING),
                    new Transition(Status.IN_PROGRESS, Status.CLOSED),
                    new Transition(Status.READY_FOR_TESTING, Status.TESTING),
                    new Transition(Status.TESTING, Status.DONE),
                    new Transition(Status.IN_PROGRESS, Status.CLOSED));

            try {
                System.out.println("Укажите ID дефекта, у которого необходимо изменить статус:");
                long changeId = Long.parseLong(scanner.nextLine());
                Defect defect = repository.getAll().get(scanner.nextLong()); // todo 3 - прочитали с консоли второй раз, упали на неверном формате

                if (repository.getById(changeId) == null) { // todo 3 - запросили дефект второй раз
                    System.out.println("Дефекта с таким id не существует");
                    continue;
                }

                System.out.println("Изменить статус дефекта на:\n ");
                Status[] values = Status.values();
                Status status = null; // todo 1 - не используется
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
                if (set.contains(new Transition(defect.getStatus(), to))) {
                    defect.setStatus(to);
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
}