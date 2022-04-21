package tracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите действие:\n" + "Добавить новый дефект - add, Вывести список - list, " +
                    "Выйти из программы - quit");
            switch (scanner.nextLine()) {
                case "add":
                    addDefect(scanner);
                    break;
                case "list":
                    for (int a = 0; a < Repository.getCounterDefectSize(); a++) {
                        System.out.println(Repository.getAll()[a].info());
                        System.out.println("_____________________________________________________________________");
                    }
                    System.out.println();
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

    private static void addDefect(Scanner scanner) {
        if (Repository.getCounterDefectSize() >= Repository.getListDefect().length) {
            System.out.println("Размер дефектов превышен");
            return;
        }

        System.out.println("//Создание баг-репорта//");
        System.out.println("Введите название дефекта");
        String name = scanner.nextLine();

        System.out.println("Введите критичность дефекта:\n" + "(trivial, minor, major, critical, blocker)");
        String critical = scanner.nextLine();

        System.out.println("Введите ожидаемое кол-во дней на исправление дефекта");
        int countDay = scanner.nextInt();
        scanner.nextLine();

        Defect defect = new Defect(name, critical, countDay);
        Repository.add(defect);

    }
}