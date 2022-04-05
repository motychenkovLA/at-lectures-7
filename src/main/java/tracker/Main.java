package tracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final int ARRAY_SIZE = 10;
        String[] arrayNameDefect = new String[ARRAY_SIZE];
        String[] arrayCriticalDefect = new String[ARRAY_SIZE];
        int[] arrayCountDayDefect = new int[ARRAY_SIZE];
        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        while (true) {
            System.out.println("Выберите действие:\n" + "Добавить новый дефект - add, Вывести список - list, " +
                    "Выйти из программы - quit");
            switch (scanner.nextLine()) {
                case "add":
                    if (counter >= arrayNameDefect.length) {
                        System.out.println("Размер дефектов превышен");
                        break;
                    }
                    System.out.println("//Создание баг-репорта//");
                    System.out.println("Введите название дефекта");
                    arrayNameDefect[counter] = scanner.nextLine();
                    System.out.println("Введите критичность дефекта:\n" + "(trivial, minor, major, critical, blocker)");
                    arrayCriticalDefect[counter] = scanner.nextLine();
                    System.out.println("Введите ожидаемое кол-во дней на исправление дефекта");
                    arrayCountDayDefect[counter] = scanner.nextInt();
                    System.out.println("\n");
                    counter++;
                    break;
                case "list":
                    for (int a = 0; a < arrayNameDefect.length; a++) {
                        if (arrayNameDefect[a] == null) {
                            break;
                        }
                        System.out.println("Номер дефекта: " + a + ", Название: "
                                + arrayNameDefect[a] + ", Критичность: "
                                + arrayCriticalDefect[a] + ", Кол-во дней: " + arrayCountDayDefect[a]);
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
}