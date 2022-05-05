package tracker;

import java.util.Scanner;

import static tracker.Repository.numberDefects;

public class Defect {
     private final long id;
     private String summary;
     private String severity;
     private int days;
     private Attachment attachment;
     private Status status;

    public Defect(String summary, String severity, int days, Attachment attachment) {
        this.summary = summary;
        this.severity = severity;
        this.days = days;
        this.id = numberDefects;
        this.attachment = attachment;
        this.status=Status.OPENED;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getInfo(){
      return id + " | " + summary + " | " + severity + " | " + days + " | " + attachment.toString() + " | " + status.getRuName();
    }


}