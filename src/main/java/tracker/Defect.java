package tracker;

import java.util.Scanner;

public class Defect {
    long id;
    String summary;
    String severity;
    int day;
    Scanner scanner = new Scanner(System.in);

    public Defect() {
    }

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

    public long getId() {
        return id;
    }

//    public void setId(long id) {
//        this.id = id;
//    }

    public String getSummary() {
        return summary;
    }

//    public void setSummary(String summary) {
//        this.summary = summary;
//    }

    public String getSeverity() {
        return severity;
    }

//    public void setSeverity(String severity) {
//        this.severity = severity;
//    }

    public int getDay() {
        return day;
    }

//    public void setDay(int day) {
//        this.day = day;
//    }

    void printDefect() {
        System.out.println(id + " | " + summary + " | "
                + severity + " | " + day);
    }
}
