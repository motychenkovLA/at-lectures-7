package lecture4;

import java.util.Scanner;

public class Defect {
     long id;
     String summary;
     String severity;
     int days;

    public Defect(long id, String summary, String severity, int days) {
        this.id = id;
        this.summary = summary;
        this.severity = severity;
        this.days = days;
    }

    public String getInfo(){
      return id + " | " + summary + " | " + severity + " | " + days;
    }
}