package tracker;

import java.util.Scanner;

public class Defect {
    long id;
    String summary;
    String severity;
    int day;
    Scanner scanner = new Scanner(System.in);


    public Defect(long id) {

        this.id = id;
        System.out.println("Введите резюме дефекта:");
        this.summary = scanner.nextLine();
        System.out.println("Введите критичность дефекта. Возможные варианты: блокирующий, высокий, средний, низкий");
        this.severity = scanner.nextLine();
        System.out.println("Введите ожидаемое количество дней на исправление:");
        this.day = scanner.nextInt();
        scanner.nextLine();
    }


    void printDefect() {
        System.out.println(id + " | " + summary + " | "
                + severity + " | " + day);
    }

}
