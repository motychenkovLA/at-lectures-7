package tracker;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите резюме дефекта:");
        String summary = scanner.nextLine();
        System.out.println("Введите критичность дефекта");
        System.out.println("Minor\nMedium\nMajor\nCritical\nBlocker");
        String severity = scanner.nextLine();
        System.out.println("Введите ожидаемое количество дней на исправление дефекта");
        int days = scanner.nextInt();
        System.out.println("Итог:\n" + "Summary=" + summary +"\n" + "Severity=" + severity + "\n" + "Количество дней на исправление=" + days + "\n" + "Займет больше рабочей недели=" + (days>5));
    }
}




