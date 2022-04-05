package tracker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // todo 1 - форматирование не как у константы
        final int arrayMax = 10;
        int[] amountOfDays = new int[arrayMax];
        String[] description = new String[arrayMax];
        String[] severity = new String[arrayMax];

        int initialValue = 0; // todo 1 - все еще не говорящее название. что такое "начальное значение"? значение чего?

        Scanner scanner = new Scanner(System.in);
        /* Главное меню */
        while (true) {
            System.out.println("Введите операцию из списка:\nadd - добавить новый дефект; " +
                    "\nlist - вывести список дефектов; \nquit - выход");
            String operation = scanner.nextLine();

            switch (operation) {
                case "add":
                    if (initialValue >= arrayMax) {
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
                    amountOfDays[initialValue] = scanner.nextInt(); // todo 3 - нет переноса курсора на чтение
                    initialValue++;
                    break;

                case "list":
                    for (int j = 0; j < initialValue; j++) {
                        System.out.println("\tНомер дефекта: " + j + "\tОписание: " + description[j] +
                                "\tКритичность: " + severity[j] + "\tКол-во дней на исправление: " + amountOfDays[j]);
                    }

                    // todo 0 - закомменченные куски кода лучше не оставлять в коммитах
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
            }
        }
    }
}

