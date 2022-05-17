package tracker;

// todo 1 - не используется
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Repository repository = new Repository(10);
        Scanner scanner = new Scanner(System.in); // todo 3 - ТЗ: работу со сканером выполнять через try-with-resources

        while (true) {
            System.out.println("Введите операцию из списка:\nadd - добавить новый дефект; " +
                    "\nchange - именить статус дефекта" + "\nlist - вывести список дефектов; \nquit - выход");
            String operation = scanner.nextLine();

            switch (operation) {
                case "add":
                    writeDefect(scanner, repository);
                    break;

                case "change":
                    changeStatus(scanner, repository);
                    break;

                case "list":
                    for (Defect i : repository.getAll()) {
                        System.out.println(i);
                        System.out.println("________________________");
                    }
                    break;

                case "quit":
                    System.out.println("Выход из системы");
                    return;

                default:
                    System.out.println("Такой операции не существует\n");
                    break;
            }
        }
    }

    private static void writeDefect(Scanner scanner, Repository repository) {
        if (repository.isFull()) {
            System.out.println("Не возможно добавить дефект");
            return;
        }

        System.out.println("Введите описание дефекта");
        String description = scanner.nextLine();

        System.out.println("Введите критичность дефекта из списка: \n");
        Severity[] values = Severity.values();
        Severity severity = null;
        for (Severity value : values) {
            System.out.println(value);
        }
        try (Scanner sc = new Scanner(System.in)) { // todo 3 - откуда-то взялся новый сканнер
            severity = Severity.valueOf(sc.nextLine());

        } catch (IllegalArgumentException e) {
            e.getStackTrace(); // todo 3 - мертвый код
            System.out.println("Введенная критичность отсутствует в списке. Введите еще раз."); // todo 3 - просит ввести еще раз но не дает возможности, выкидывает обратно в меню
            return;
        }
// Ниже у меня падает c NoSuchElementException. Не пойму как исправить.
        System.out.println("Дни на исправление дефекта:");
        int amountOfDays = 0;
        try (Scanner sc = new Scanner(System.in)) { // todo 3 - ещё один сканнер
            amountOfDays = sc.nextInt();
            sc.nextLine();
        } catch (NumberFormatException e) {
            e.printStackTrace(); // todo 3 - зачем пользователю стек?
            System.out.println("Вводимое значение должно быть числом. Введите еще раз."); // todo 3 - просит ввести еще раз но не дает возможности, выкидывает обратно в меню
        }

        Attachment attachment = createAttachment(scanner);

        Defect defect = new Defect(description, severity, amountOfDays, attachment);
        repository.add(defect);
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
                    long linkId = scanner.nextLong();
                    scanner.nextLine();
                    result = new DefectAttachment(linkId);
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
        System.out.println("Укажите ID дефекта, у которого необходимо изменить статус:");
        long changeId = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Изменить статус дефекта на:\n ");
        Status[] values = Status.values();
        Status status = null;
        for (Status value : values) {
            System.out.println(value);
        }
        try (Scanner sc = new Scanner(System.in)) {// todo 3 - ещё один сканнер
            status = Status.valueOf(sc.nextLine());
        } catch (IllegalArgumentException e) {
            e.getStackTrace(); // todo 3 - мертвый код
            System.out.println("Введенный статус отсутствует в списке. Введите еще раз."); // todo 3 - просит ввести еще раз но не дает возможности, выкидывает обратно в меню
            return;
        }

        // todo 3 - забирает все дефекты из репо причем не раз, лучше просто получить нужный дефект по id от репо
        for (int i = 0; i < repository.getCounter(); i++) {
            if (i == changeId) {
                repository.getAll()[i].setStatus(status);
            }
        }
    }
}



