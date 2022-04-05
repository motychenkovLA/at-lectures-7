package tracker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int ARRAYMAX = 10;
        int[] amountOfDays = new int[ARRAYMAX];
        String[] description = new String[ARRAYMAX];
        String[] severity = new String[ARRAYMAX];

        int count = 0;

        Scanner scanner = new Scanner(System.in);
        /* Главное меню */
        while (true) {
            System.out.println("Введите операцию из списка:\nadd - добавить новый дефект; " +
                    "\nlist - вывести список дефектов; \nquit - выход");
            String operation = scanner.nextLine();

            switch (operation) {
                case "add":
                    if (count >= ARRAYMAX) {
                        System.out.println("Не возможно добавить дефект");
                        break;
                    }

                    System.out.println("Введите описание дефекта");
                    description[count] = scanner.nextLine();

                    System.out.println("Выберите кричтичность дефектов из:\n" +
                            "-Blocker\n" +
                            "-Critical\n" +
                            "-Major\n" +
                            "-Minor\n" +
                            "-Trivial\n");
                    severity[count] = scanner.nextLine();

                    System.out.println("Дни на исправление дефекта:");
                    amountOfDays[count] = scanner.nextInt();
                    scanner.nextLine();
                    count++;
                    break;

                case "list":
                    for (int j = 0; j < count; j++) {
                        System.out.println("\tНомер дефекта: " + j + "\tОписание: " + description[j] +
                                "\tКритичность: " + severity[j] + "\tКол-во дней на исправление: " + amountOfDays[j]);
                    }
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

