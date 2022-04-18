package tracker;

import java.util.Scanner;

public class Tracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Введите операцию из списка:\nadd - добавить новый дефект\nlist - вывести список дефектов\nquit - выход");
            System.out.println();

            switch (sc.nextLine()) {
                case "add":
                    addDefect(sc);
                    System.out.println();
                    break;
                case "list":
                    Repository.getAll();
                    break;
                case "quit":
                    System.out.println("Выход из системы");
                    return;
                default:
                    System.out.println("Введена не существующая операция");
                    System.out.println();
            }
        }
    }

    public static void addDefect(Scanner scanner) {
        if(Repository.counterArray >= Repository.listDefect.length) {
            try {
                throw new IndexOutOfBoundsException();
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
                return;
            }
        }

        System.out.println("Введите резюме дефекта");
        String summary = scanner.nextLine();
        Defect defect = new Defect(summary);

        System.out.println("Введите критичность дефекта из списка:" + "\ntrivial, minor, major, critical, blocker");
        defect.setCriticality(scanner.nextLine());


        System.out.println("Введите количество дней на исправление");
        defect.setCountDay(scanner.nextInt());
        scanner.nextLine();

        Repository.addDef(defect);
    }
}

