package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int daysInWorkWeek = 5;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите резюме дефекта");
        String defectDescription = scanner.nextLine();
        System.out.println("Введите критичность дефекта (Blocker, Critical, Major, Minor, Trivial)");
        String defectSeverity = scanner.nextLine();
        System.out.println("Введите ожидаемое количество дней на исправление дефекта");
        int daysToFix = scanner.nextInt();
        System.out.println("Описание дефекта: " + "\n" + defectDescription + "\n" + "Критичность дефекта:" + "\n" +
                defectSeverity + "\n" + "Количество дней на исправление дефекта: " + daysToFix + "\n" +
                "Займет больше рабочей недели: " + (daysToFix > daysInWorkWeek));
    }
}
