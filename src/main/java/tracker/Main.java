package tracker;

import java.util.Scanner;

import static tracker.Repository.numberDefects;

public class Main {

    public static void main(String[] args) {
        Repository repository = new Repository(10);
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Введите действие: добавить новый дефект (\"add\") или изменить статус дефекта (\"change\") или вывести список (\"list\") или выйти из программы (\"quit\") - главное меню ");
            switch (scanner.nextLine()) {
                case ("add"):
                    Attachment attachment;
                    System.out.println("Выберите тип дефекта");
                    System.out.println("Комментарий (\"comment\") или ссылка(\"link\")");
                    switch (scanner.nextLine()) {
                        case ("comment"):
                            attachment = new CommentAttachment(scanner.nextLine());
                            break;
                        case ("link"):
                            attachment = new DefectAttachment(scanner.nextLong());
                            break;
                        default:
                            attachment=null;
                    }
                    System.out.println("Введите резюме дефекта:");
                    String summary = scanner.nextLine();
                    System.out.println("Введите критичность дефекта");
                    System.out.println("Minor\nMedium\nMajor\nCritical\nBlocker");
                    String severity = scanner.nextLine();
                    System.out.println("Введите ожидаемое количество дней на исправление дефекта");
                    int days = scanner.nextInt();
                    scanner.nextLine();
                    Defect bugs = new Defect(summary, severity, days, attachment);
                    repository.add(bugs);
                    break;

                case("change"):
                    System.out.println("Укажите ID дефекта, у которого необходимо изменить статус:");
                    long changeId = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Изменить статус дефекта на:");
                    Status[] values = Status.values();
                    for (Status value : values) {
                        System.out.println(value);
                    }
                    Status status = Status.valueOf(scanner.nextLine());
                    for (int x = 0; x < numberDefects; x++) {
                        if (x == changeId) {
                            repository.getAll()[x].setStatus(status);
                        }
                    }
                    break;

                case ("list"):
                    Defect[] defects = repository.getAll();
                    for (int i = 0; i < numberDefects; i++) {
                        System.out.println(defects[i].getInfo());
                    }
                    break;

                case("quit"):
                    return;
            }
        }
        while (true);
    }
}




