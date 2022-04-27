package tracker;

import java.util.Scanner;

import static tracker.Repository.numberDefects;

public class Main {

    public static void main(String[] args) {
        Repository repository = new Repository(10);
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Введите действие: добавить новый дефект (\"add\") или вывести список (\"list\") или выйти из программы (\"quit\") - главное меню ");
            switch (scanner.nextLine()) {
                case ("add"):
                    System.out.println("Введите резюме дефекта:");
                    String summary = scanner.nextLine();
                    System.out.println("Введите критичность дефекта");
                    System.out.println("Minor\nMedium\nMajor\nCritical\nBlocker");
                    String severity = scanner.nextLine();
                    System.out.println("Введите ожидаемое количество дней на исправление дефекта");
                    int days = scanner.nextInt();
                    scanner.nextLine();
                    Defect bug = new Defect(summary, severity, days);
                    repository.add(bug);
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




