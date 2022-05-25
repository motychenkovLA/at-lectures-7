package tracker;

import java.util.Objects;

public class Defect {
    private final long id;
    private String summary;
    private int countDay;
    private Severity severity;
    private Attachment attachment;
    private Status status;
    private static long numberDefects = 1;

    public Defect(String summary, Severity severity, int countDay, Attachment attachment) {
        this.attachment = attachment;
        this.summary = summary;
        this.severity = severity;
        this.countDay = countDay;
        this.status = Status.OPEN;
        this.id = numberDefects++;
    }

    public Status getStatus() {
        return status;
    }

    public long getID() {
        return id;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String toString() {
        // todo 3 - attachment не может быть нулевым в текущей реализации
        return attachment == null ? "Defect:"+"\nНомер дефекта: "+ id +"\nНазвание = "+summary+
                "\nКритичность = "+severity.getName()+"\nКол-во дней = "+countDay+
                "\nСтатус = "+status.getRuName()+"\n":
                "Defect:"+"\nНомер дефекта = "+ id +"\nНазвание = "+summary+
                        "\nКритичность = "+severity.getName()+"\nКол-во дней = "+countDay+
                        "\nСтатус = "+status.getRuName()+"\n"+attachment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Defect defect = (Defect) o;
        return this.id == defect.id &&
                this.countDay == defect.countDay &&
                this.summary.equals(defect.summary) &&
                this.severity.equals(defect.severity) &&
                this.attachment.equals(defect.attachment) &&
                this.status.equals(defect.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, summary, countDay, severity, attachment, status);
    }

}