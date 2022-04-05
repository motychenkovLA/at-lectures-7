package tracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final int WORKING_DAYS_IN_WEEK = 5;     // Рабочая неделя

        String[] arrayResumeBag = new String[10];
        String[] arrayCritical = new String[10];
        int[] arrayDaysCorrection = new int[10];

        int i = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите одно из действий:" +
                    "\n add - Завести новый дефект" +
                    "\n list - Показать перечень дефектов" +
                    "\n quit - Выход из программы");

            switch (scanner.nextLine()) {

                case "add":
                    if (i >= arrayResumeBag.length) {
                        System.out.println("Уже заведено 10 дефектов");
                        break;
                    }

                    System.out.println("Введите резюме по дефекту:");
                    arrayResumeBag[i] = scanner.nextLine();

                    System.out.println("Введите критичность дефекта (Низкий, Средний, Высокий, Блокирующий):");
                    arrayCritical[i] = scanner.nextLine();

                    System.out.println("Введите количество дней на исправление:");
                    arrayDaysCorrection[i] = scanner.nextInt();
                    scanner.nextLine();

                    i++;
                    break;

                case "list":
                    int r = 0;
                    while (i > r) {
                        System.out.println(
                                "Номер дефекта " + r + ":" +
                                        "\n Описание дефекта: " + arrayResumeBag[r] +
                                        "\n Критичность: " + arrayCritical[r] +
                                        "\n Количество дней на исправление: " + arrayDaysCorrection[r] +
                                        "\n Будет исправлен за рабочую неделю: " + (arrayDaysCorrection[r] <= WORKING_DAYS_IN_WEEK) +
                                        "\n________________________________________________________"
                        );
                        r++;
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
