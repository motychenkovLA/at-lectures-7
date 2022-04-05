package tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        List<String> bugs = new ArrayList<>();
        int count = 0;
        boolean isWork = true;
        do {
            System.out.println("Введите действие: добавить новый дефект (\"add\") или вывести список (\"list\") или выйти из программы (\"quit\") - главное меню ");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextLine()){
                case("add"):
                    if(count <= 9){
                        System.out.println("Введите резюме дефекта:");
                        String summary = scanner.nextLine();
                        System.out.println("Введите критичность дефекта");
                        System.out.println("Minor\nMedium\nMajor\nCritical\nBlocker");
                        String severity = scanner.nextLine();
                        System.out.println("Введите ожидаемое количество дней на исправление дефекта");
                        int days = scanner.nextInt();
                        bugs.add(count + " | " + summary + " | " + severity + " | " + days);
                        count++;
                    }
                    else {
                        System.out.println("Превышено максимальное количество дефектов");
                    }
                    break;
                case("list"):
                    for (String bug : bugs) {
                        System.out.println(bug);
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




