package tracker;

import java.util.Scanner;

public class Defect {
    private static long num = 0L;

    private long id;
    private String summary;
    private String severity;
    private int day;

    Scanner scanner = new Scanner(System.in);

    public Defect(String summary, String severity, int day) {

        num++;
        this.id = num;
        this.summary = summary;
        this.severity = severity;
        this.day = day;
    }

    public long getId() {
        return id;
    }

    public String getSummary() {
        return summary;
    }

    public String getSeverity() {
        return severity;
    }

    public int getDay() {
        return day;
    }
}
