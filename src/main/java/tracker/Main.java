package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите резюме дефекта");
        String defectDescription = scanner.nextLine();
        System.out.println("Введите критичность дефекта (Blocker, Critical, Major, Minor, Trivial)");
        String defectSeverity = scanner.nextLine();
        System.out.println("Введите ожидаемое количество дней на исправление дефекта");
        int workDays = scanner.nextInt();
        System.out.println("Описание дефекта: " + "\n" + defectDescription + "\n" + "Критичность дефекта:" + "\n" +
                defectSeverity + "\n" + "Количество дней на исправление дефекта: " + workDays + "\n" + "Займет больше рабочей недели: " + (workDays > 5));
    }
}
