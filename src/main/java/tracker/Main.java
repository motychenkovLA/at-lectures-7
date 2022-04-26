package tracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int count = 0;
        Repository repository = new Repository(10);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите одно из действий:" +
                    "\n add - Завести новый дефект" +
                    "\n list - Показать перечень дефектов" +
                    "\n quit - Выход из программы");

            switch (scanner.nextLine()) {

                case "add":
                    if (repository.isComplet()) {
                        System.out.println("Уже заведено 10 дефектов");
                        break;
                    }

                    System.out.println("Введите резюме по дефекту:");
                    String resume = scanner.nextLine();

                    System.out.println("Введите критичность дефекта (Низкий, Средний, Высокий, Блокирующий):");
                    String critical = scanner.nextLine();

                    System.out.println("Введите количество дней на исправление:");
                    int dayToFix = scanner.nextInt();
                    scanner.nextLine();

                    Defect defect = new Defect(resume, critical, dayToFix);
                    repository.addDefect(defect);
                    count++;
                    break;

                case "list":
                    for (Defect r : repository.getAll()) {
                        if (r != null) System.out.println(r.list());
                    }
                    break;

                case "quit":
                    System.out.println("Quit");
                    return;

                default:
                    System.out.println("Возврат в главное меню");
                    break;
            }
        }

    }

}
