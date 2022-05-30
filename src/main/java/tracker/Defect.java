package tracker;

import java.util.Objects;
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

    public Status getStatus(){
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String toString(){
      return id + " | " + summary + " | " + severity + " | " + days + " | " + attachment.toString() + " | " + status.getRuName();
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Defect defect = (Defect) o;
        return this.id == defect.id &&
                this.days == defect.days &&
                this.summary.equals(defect.summary) &&
                this.severity.equals(defect.severity) &&
                this.attachment.equals(defect.attachment) &&
                this.status.equals(defect.status);
    }

    @Override
public int hashCode(){
    return Objects.hash(id, summary, days, severity, attachment, status);
    }
}