package tracker;

import java.util.Scanner;

public class Defect {
    private long id;
    private String summary;
    private String severity;
    private int day;
    static long num = 0L;
    Scanner scanner = new Scanner(System.in);


    //public Defect(long id,String summary, String severity, int day) {
    public Defect(String summary, String severity, int day) {
        //this.id = id;
        num++;
        this.id = num;
        this.summary = summary;
        this.severity = severity;
        this.day = day;
    }

    void printDefect() {
        System.out.println(id + " | " + summary + " | "
                + severity + " | " + day);
    }

}
