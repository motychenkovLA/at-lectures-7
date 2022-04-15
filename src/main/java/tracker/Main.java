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
                    addDefect();
                    break;
                case "list":
                    for (int a=0; a<ListDefect.counter; a++) {
                        System.out.println(ListDefect.listDefect[a]);
                        System.out.println("_________________________________________________________");
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
    public static void addDefect() {
        if (ListDefect.counter >= ListDefect.listDefect.length) {
            System.out.println("Размер дефектов превышен");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("//Создание баг-репорта//");
        System.out.println("Введите название дефекта");
        String nameDefect = scanner.nextLine();
        Defect defect = new Defect(nameDefect);

        System.out.println("Введите критичность дефекта:\n" + "(trivial, minor, major, critical, blocker)");
        String criticalDefect = scanner.nextLine();
        defect.setCriticalDefect(criticalDefect);

        System.out.println("Введите ожидаемое кол-во дней на исправление дефекта");
        int countDayDefect = scanner.nextInt();
        scanner.nextLine();
        defect.setCountDayDefect(countDayDefect);
        ListDefect.list(defect);
    }
}