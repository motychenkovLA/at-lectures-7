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
                    for(int i = 0; i < Repository.getCounterArray(); i++) {
                        System.out.println(Repository.getAll()[i].info());
                        System.out.println("________________________");
                }
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
        if(Repository.getCounterArray() >= Repository.getListDefect().length) {
            System.out.println("Обращение к индексу больше размера массива");
            return;
        }

        System.out.println("Введите резюме дефекта");
        String summary = scanner.nextLine();


        System.out.println("Введите критичность дефекта из списка:" + "\ntrivial, minor, major, critical, blocker");
        String criticality = scanner.nextLine();

        System.out.println("Введите количество дней на исправление");
        int countDay = scanner.nextInt();
        scanner.nextLine();

        Defect defect = new Defect(summary, criticality, countDay);

        Repository.addDef(defect);
    }
}

