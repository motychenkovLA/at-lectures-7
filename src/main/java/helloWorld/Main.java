package helloWorld;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final int WORKING_WEEK = 5;

        String[] bugTable = new String[10];


        int i = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:" +
                    "\n add - Завести дефект" +
                    "\n list - Показать список дефектов" +
                    "\n quit - Выход из программы");

            switch (scanner.nextLine()) {

                case "add":
                    if (i >= bugTable.length) {
                        System.out.println("Уже заведено 10 дефектов");
                        break;
                    }

                    System.out.println("Введите резюме дефекта:");
                    String bugReport = scanner.nextLine();

                    System.out.println("Введите критичность дефекта (Высокая, Средняя, Низкая):");
                    String critical = scanner.nextLine();

                    System.out.println("Введите срок исправления дефекта, в днях:");
                    int daysToRepair = scanner.nextInt();
                    scanner.nextLine();

                    bugTable[i] = "Номер дефекта " + i + ":" +
                            "\n Описание дефекта: " + bugReport +
                            "\n Критичность: " + critical +
                            "\n Количество дней на исправление: " + daysToRepair +
                            "\n Займет больше рабочей недели: " + (daysToRepair <= WORKING_WEEK) +
                            "\n________________________________________________________";

                    i++;
                    break;

                case "list":
                    for (String q : bugTable) {
                        if (q != null) System.out.println(q);
                    }
                    break;

                case "quit":
                    System.out.println("Quit");
                    return;

                default:
                    System.out.println("Возврат в главное меню");
                    break;
            }
        }

    }

}