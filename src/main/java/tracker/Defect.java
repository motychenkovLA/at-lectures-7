package tracker;

import java.util.Scanner;

import static tracker.Repository.numberDefects;

public class Defect {
     private final long id;
     private String summary;
     private String severity;
     private int days;

    public Defect(String summary, String severity, int days) {
        this.summary = summary;
        this.severity = severity;
        this.days = days;
        this.id = numberDefects;
    }

    public String getInfo(){
      return id + " | " + summary + " | " + severity + " | " + days;
    }


}