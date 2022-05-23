package tracker;

import java.util.Objects;

public class Defect {
    private final long ID;
    private final int WEEK = 5;
    private String summary;
    private int countDay;
    private Criticality criticality;
    private Attachment attachment;
    private Status status;
    private static long numberDefects = 1;

    public Defect(String summary, Criticality criticality, int countDay) {
        this.summary = summary;
        this.criticality = criticality;
        this.countDay = countDay;
        this.status = Status.OPEN;
        this.ID = numberDefects++;
    }

    public Defect(String summary, Criticality criticality, int countDay, Attachment attachment) {
        this(summary, criticality, countDay);
        this.attachment = attachment;
    }

    public long getID() {
        return ID;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String toString() {
        return attachment == null ? "Defect:"+"\nid = "+ ID +"\nРезюме = "+summary+"\nКритичность = "+criticality.getName()+"\ncountDay = "+countDay+
                    "\nИсправление займет больше рабочей недели = "+(countDay > WEEK)+"\nСтатус = "+status.getTranslation()+"\n":
                "Defect:"+"\nid = "+ ID +"\nРезюме = "+summary+"\nКритичность = "+criticality.getName()+"\ncountDay = "+countDay+
               "\nИсправление займет больше рабочей недели = "+(countDay > WEEK)+"\nСтатус = "+status.getTranslation()+"\n"+attachment;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        Defect defect = (Defect) o;
        if(this.hashCode() != o.hashCode()) return false;
        return this.ID == defect.ID &&
                this.countDay == defect.countDay &&
                this.summary.equals(defect.summary) &&
                this.status == defect.status &&
                this.criticality == defect.criticality &&
                this.attachment.equals(defect.attachment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, summary, countDay, criticality, attachment, status);
    }
}




