package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите резюме дефекта:");
        Scanner scanner = new Scanner(System.in);
        String summary = scanner.nextLine();

        System.out.println("Введите критичность дефекта. Возможные варианты:" + "\n" +
                "блокирующий" + "\n" + "высокий" + "\n" + "средний" + "\n" + "низкий");
        String severity = scanner.nextLine();

        System.out.println("Введите ожидаемое количество дней на исправление:");
        int day = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Зарегистрирован дефект:");
        System.out.println("Резюме: " + summary);
        System.out.println("Критичность: " + severity);
        System.out.println("Количество дней на исправление: " + day +
                "\n" + "Займет больше рабочей недели: " + (day > 5));
    }
}
