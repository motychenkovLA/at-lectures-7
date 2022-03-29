package tracker;

import java.util.Scanner;

public class Tracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите резюме дефекта");
        String summary = scanner.nextLine();

        System.out.println("Введите критичность дефекта из списка\n"+"trivial, minor, major, critical, blocker");
        String critical = scanner.nextLine();

        System.out.println("Введите количество дней на исправление");
        int countDay = scanner.nextInt();

        System.out.println(summary+", "+critical+", "+countDay+", Исправление займет больше рабочей недели: "+(countDay > 5));

        scanner.close();
    }
}
