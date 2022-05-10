package tracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        int count = 0;
        Repository repository = new Repository(10);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:" +
                    "\n add - Завести дефект" +
                    "\n list - Показать список дефектов" +
                    "\n quit - Выход из программы");

            switch (scanner.nextLine()) {

                case "add":
                    if (repository.isFull()) {
                        System.out.println("Уже заведено 10 дефектов");
                        break;
                    }

                    System.out.println("Введите резюме дефекта:");
                    String resume = scanner.nextLine();
                    System.out.println("Введите критичность дефекта (Высокая, Средняя, Низкая):");
                    String critical = scanner.nextLine();
                    System.out.println("Введите срок исправления дефекта, в днях:");
                    int dayToRepair = scanner.nextInt();
                    scanner.nextLine();
                    Defect defect = new Defect(resume, critical, dayToRepair);
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