package tracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] arrayDefect = new String[10];
        String[] arrayDefect1 = new String[10];
        int[] arrayDefect2 = new int[10];
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while (true) {
            System.out.println("Выберите действие:\n" + "Добавить новый дефект - add, Вывести список - list, " +
                    "Выйти из программы - quit");
            switch (scanner.nextLine()) {
                case "add":
                    if (i >= arrayDefect.length) {
                        System.out.println("Размер дефектов превышен");
                        break;
                    }
                    System.out.println("//Создание баг-репорта//");
                    System.out.println("Введите название дефекта");
                    String name = scanner.nextLine();
                    System.out.println("Введите критичность дефекта:\n" + "(trivial, minor, major, critical, blocker)");
                    String critical = scanner.nextLine();
                    System.out.println("Введите ожидаемое кол-во дней на исправление дефекта");
                    int countDay = scanner.nextInt();
                    System.out.println();
                    arrayDefect[i] = name;
                    arrayDefect1[i] = critical;
                    arrayDefect2[i] = countDay;
                    i++;
                    break;
                case "list":
                    for (int a = 0; a < arrayDefect.length; a++) {
                        System.out.println("Номер дефекта: " + a + ", Название: " + arrayDefect[a] + ", Критичность: "
                                + arrayDefect1[a] + ", Кол-во дней: " + arrayDefect2[a]);
                    }
                    System.out.println();
                    break;
                case "quit":
                    System.out.println("Выход из программы");
                    return;
                default:
                    System.out.println("try again");
                    System.out.println();
            }
        }
    }
}