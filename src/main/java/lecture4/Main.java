package lecture4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Defect> defects = new ArrayList<>();
        int count = 0;
        boolean isWork = true;
        do {
            System.out.println("Введите действие: добавить новый дефект (\"add\") или вывести список (\"list\") или выйти из программы (\"quit\") - главное меню ");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextLine()){
                case("add"):
                        System.out.println("Введите резюме дефекта:");
                        String summary = scanner.nextLine();
                        System.out.println("Введите критичность дефекта");
                        System.out.println("Minor\nMedium\nMajor\nCritical\nBlocker");
                        String severity = scanner.nextLine();
                        System.out.println("Введите ожидаемое количество дней на исправление дефекта");
                        int days = scanner.nextInt();
                        Defect bug = new Defect(count, summary, severity,days );
                        defects.add(bug);
                        count++;
                        break;

                case("list"):
                    for (Defect defect : defects) {
                        defect.getInfo();
                    }
                    break;
                case("quit"):
                    isWork = false;
                    break;
            }
        }
        while (isWork);
    }

    }
