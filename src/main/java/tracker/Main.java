package tracker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int arrayMax = 10;
        // todo 3 - 10 это константа - исправлено
        int[] amountOfDays = new int[arrayMax]; // todo 1 - не говорящее название - исправлено
        String[] description = new String[arrayMax];
        String[] severity = new String[arrayMax];

        int initialValue = 0; // todo 1 - не говорящее название - исправлено

        Scanner scanner = new Scanner(System.in);
        /* Главное меню */
        while (true) {
            System.out.println("Введите операцию из списка:\nadd - добавить новый дефект; " +
                    "\nlist - вывести список дефектов; \nquit - выход");
            String operation = scanner.nextLine();

            switch (operation) {
                case "add":
                    if (initialValue >= arrayMax) { // todo 0 - "a > b - 1" и "a >= b" -исправлено
                        System.out.println("Не возможно добавить дефект");
                        break;
                    }

                    System.out.println("Введите описание дефекта");
                    description[initialValue] = scanner.nextLine();

                    System.out.println("Выберите кричтичность дефектов из:\n" +
                            "-Blocker\n" +
                            "-Critical\n" +
                            "-Major\n" +
                            "-Minor\n" +
                            "-Trivial\n");
                    severity[initialValue] = scanner.nextLine();

                    System.out.println("Дни на исправление дефекта:");
                    amountOfDays[initialValue] = scanner.nextInt();
                    initialValue++;
                    break;

                case "list":
                    // todo 5 - выводятся незаполненные дефекты - выводится одна строка

                    for (int j = 0; j < initialValue; j++) {
                        System.out.println("\tНомер дефекта: " + j + "\tОписание: " + description[j] +
                                "\tКритичность: " + severity[j] + "\tКол-во дней на исправление: " + amountOfDays[j]);
                    }

                    /*Второй вариант*/
//                    for (int j = 0; j < description.length; j++) {
//                        if (description[j]==null) {
//                            break;
//                        }
//                        System.out.println("\tНомер дефекта: " + j + "\tОписание: " + description[j] +
//                                "\tКритичность: " + severity[j] + "\tКол-во дней на исправление: " + amountOfDays[j]);
//                    }
                    System.out.println();
                    break;


                case "quit":
                    System.out.println("Выход из системы");
                    return;

                default:
                    System.out.println("Такой операции не существует\n");
                    break;
                    // todo 1 - по хорошему надо тоже break для одинаковости веток - исправлено
            }
        }
    }
}

