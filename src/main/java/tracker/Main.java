package tracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final int WORKING_DAYS_IN_WEEK = 5;     // Рабочая неделя

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите резюме по дефекту:");
        String resumeBag = scanner.nextLine();

        System.out.println("Введите критичность дефекта (Низкий, Средний, Высокий, Блокирующий):");
        String critical = scanner.nextLine();

        System.out.println("Введите количество дней на исправление:");
        int daysCorrection = scanner.nextInt();
        scanner.nextLine();

        System.out.println(
                "Итог:" +
                        "\n Описание дефекта:" + resumeBag +
                        "\n Критичность:" + critical +
                        "\n Количество дней на исправление:" + daysCorrection +
                        "\n Будет исправлен за рабочую неделю:" + (daysCorrection <= WORKING_DAYS_IN_WEEK)
        );

    }

}
