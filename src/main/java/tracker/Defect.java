package tracker;

import java.util.Scanner;

public class Defect {
    private long id;
    private String summary;
    private String severity;
    private int day;
    private long num;
    Scanner scanner = new Scanner(System.in);

    public Defect(long id, String summary, String severity, int day) {
        this.id = id;
        this.summary = summary;
        this.severity = severity;
        this.day = day;
    }

    void printDefect() {
        System.out.println(id + " | " + summary + " | "
                + severity + " | " + day);
    }

}
