package lecture4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Defect[] list = new Defect[10];
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Введите действие: добавить новый дефект (\"add\") или вывести список (\"list\") или выйти из программы (\"quit\") - главное меню ");
            switch (scanner.nextLine()) {
                case ("add"):
                    System.out.println("Введите резюме дефекта:");
                    String summary = scanner.nextLine();
                    System.out.println("Введите критичность дефекта");
                    System.out.println("Minor\nMedium\nMajor\nCritical\nBlocker");
                    String severity = scanner.nextLine();
                    System.out.println("Введите ожидаемое количество дней на исправление дефекта");
                    int days = scanner.nextInt();
                    scanner.nextLine();
                    Defect bugs = new Defect(count, summary, severity, days);
                    list[count] = bugs;
                    count++;
                    break;

                case ("list"):
                    for (int i = 0; i < count; i++) {
                        System.out.println(list[i].getInfo());
                    }
                    break;
                case("quit"):
                    return;
            }
        }
        while (true);
    }
}