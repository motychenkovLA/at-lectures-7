package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[] number = new int[2];
        String[] description = new String[2];
        String[] severity = new String[2];

        int i = 0;

        Scanner scanner = new Scanner(System.in);
        /* Главное меню */
        while (true) {
            System.out.println("Введите операцию из списка:\nadd - добавить новый дефект; " +
                    "\nlist - вывести список дефектов; \nquit - выход");
            String operation = scanner.nextLine();

            switch (operation) {
                case "add":
                    if (i > description.length - 1) {
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
            }
        }
    }
}

