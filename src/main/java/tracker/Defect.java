package tracker;

import java.util.Objects;

public class Defect {
    private final long ID;
    private String summary;
    private int countDay;
    private Severity severity;
    private Attachment attachment;
    private Status status;
    private static long numberDefects = 1;


    public Defect(String summary, Severity severity, int countDay) {
        this.summary = summary;
        this.severity = severity;
        this.countDay = countDay;
        this.status = Status.OPEN;
        this.ID = numberDefects++;
    }

    public Defect(String summary, Severity severity, int countDay, Attachment attachment) {
        this(summary, severity, countDay);
        this.attachment = attachment;
    }

    public long getID() {
        return ID;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String toString() {
        return attachment == null ? "Defect:"+"\nНомер дефекта: "+ ID +"\nНазвание = "+summary+
                "\nКритичность = "+severity.getName()+"\nКол-во дней = "+countDay+
                "\nСтатус = "+status.getRuName()+"\n":
                "Defect:"+"\nНомер дефекта = "+ ID +"\nНазвание = "+summary+
                        "\nКритичность = "+severity.getName()+"\nКол-во дней = "+countDay+
                        "\nСтатус = "+status.getRuName()+"\n"+attachment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Defect defect = (Defect) o;
        if(this.hashCode() != o.hashCode()) return false;
        return this.ID == defect.ID &&
                this.countDay == defect.countDay &&
                this.summary.equals(defect.summary) &&
                this.severity.equals(defect.severity) &&
                this.attachment.equals(defect.attachment) &&
                this.status.equals(defect.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, summary, countDay, severity, attachment, status);
    }

}