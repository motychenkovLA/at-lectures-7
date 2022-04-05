package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // todo 3 - 10 это константа
        int[] number = new int[10]; // todo 1 - не говорящее название
        String[] description = new String[10];
        String[] severity = new String[10];

        int i = 0; // todo 1 - не говорящее название

        Scanner scanner = new Scanner(System.in);
        /* Главное меню */
        while (true) {
            System.out.println("Введите операцию из списка:\nadd - добавить новый дефект; " +
                    "\nlist - вывести список дефектов; \nquit - выход");
            String operation = scanner.nextLine();

            switch (operation) {
                case "add":
                    if (i > description.length - 1) { // todo 0 - "a > b - 1" и "a >= b" это то же самое но второе попроще читать
                        System.out.println("Не возможно добавить дефект");
                        break;
                    }

                    System.out.println("Введите описание дефекта");
                    description[i] = scanner.nextLine();

                    System.out.println("Выберите кричтичность дефектов из:\n" +
                            "-Blocker\n" +
                            "-Critical\n" +
                            "-Major\n" +
                            "-Minor\n" +
                            "-Trivial\n");
                    severity[i] = scanner.nextLine();

                    System.out.println("Дни на исправление дефекта:");
                    number[i] = scanner.nextInt();
                    i++;
                    break;

                case "list":
                    // todo 5 - выводятся незаполненные дефекты
                    for (int j = 0; j < description.length; j++) {
                        System.out.println("\tНомер дефекта: " + j + "\tОписание: " + description[i] +
                                "\tКритичность: " + severity[i] + "\tКол-во дней на исправление: " + number[i]);
                    }
                    System.out.println();
                    break;

                case "quit":
                    System.out.println("Выход из системы");
                    return;

                default:
                    System.out.println("Такой операции не существует\n");
                    // todo 1 - по хорошему надо тоже break для одинаковости веток
            }
        }
    }
}

