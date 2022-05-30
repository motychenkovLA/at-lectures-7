package tracker;

import java.util.Locale;
import java.util.Scanner;

import static tracker.Repository.numberDefects;

public class Main {

    public static void main(String[] args) {
        Repository repository = new Repository(10);
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Введите действие: добавить новый дефект (\"add\") или изменить статус дефекта (\"change\") или вывести список (\"list\") или выйти из программы (\"quit\") - главное меню ");
                switch (scanner.nextLine()) {
                    case ("add"):
                        add(scanner, repository);
                        break;

                    case ("change"):
                        change(scanner, repository);
                        break;

                    case ("list"):
                       for (Defect defect:repository.getAll()){
                           System.out.println(defect);
                       }
                        break;

                    case ("quit"):
                        return;

                    default:
                        System.out.println("Попробуй еще");
                        System.out.println();
                        break;
                }
            }
        }
    }

    public static void add (Scanner scanner, Repository repository) {

        System.out.println("Введите резюме дефекта:");
        String summary = scanner.nextLine();

        Severity severity = createSeverity(scanner);

        int countDays = createCountDays(scanner);

        Attachment attachment = createAttachment(scanner);

        Defect bugs = new Defect(summary, severity.toString(), countDays, attachment);
        repository.add(bugs);
    }

    private static int createCountDays(Scanner scanner){
        System.out.println("Введите ожидаемое количество дней на исправление дефекта");
        int days = 0;
        while (days<=0) {
            try {
                days = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Некорректное количество дней, введите число");
            }
        }
        return days;
    }

    private static Severity createSeverity(Scanner scanner) {
        System.out.println("Введите критичность дефекта");
        Severity[] values = Severity.values();
        Severity severity = null;
        while (severity == null) {
            for (Severity value : values) {
                System.out.println(value);
            }
            try {
                severity = Severity.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Введено несуществующее значение, выберете значение из списка");
            }
        }
        return severity;
    }

    private static Attachment createAttachment(Scanner scanner) {
        Attachment attachment = null;

        while (attachment == null) {
            System.out.println("Выберите тип дефекта");
            System.out.println("Комментарий (\"comment\") или ссылка(\"link\")");
            String attachments = scanner.nextLine();

            switch (attachments) {
                case ("link"):
                    System.out.println("Введите id дефекта");
                    while (true) {
                        try {
                            long id = Long.parseLong(scanner.nextLine());
                            attachment = new DefectAttachment(id);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Неверный формат. Введите еще раз");
                        }
                    }
                        break;

                case ("comment"):
                    attachment = new CommentAttachment(scanner.nextLine());
                    break;
                default:
                    System.out.println("Такого типа вложения не существует");
                    break;
            }
        }
            return attachment;
        }

        public static void change (Scanner scanner, Repository repository){
            while (true) {
                try {
                    System.out.println("Укажите ID дефекта, у которого необходимо изменить статус:");
                    long changeId = Long.parseLong(scanner.nextLine());
                    if (repository.getById(changeId) == null) {
                        System.out.println("Такого id не существует");
                        continue;
                    }
                    System.out.println("Изменить статус дефекта на:");
                    Status[] values = Status.values();
                    Status status = null;

                    while (status == null) {
                        for (Status value : values) {
                            System.out.println(value);
                        }
                        try {
                            status = Status.valueOf(scanner.nextLine().toUpperCase());
                            status = Status.valueOf(scanner.nextLine());
                        } catch (IllegalArgumentException e) {
                            System.out.println("Такого статуса нет в списке, выберете значение из списка");
                        }
                    }
                    repository.getById(changeId).setStatus(status);
                } catch (NumberFormatException e) {
                    System.out.println("Неверный статус");
                }
                break;
                }
            }
        }
