package tracker;


import java.util.Objects;

public class Defect {
    private final long id;
    private String resume;
    private int daysToFix;
    private static long currentID = 1;
    private Attachment attachment;
    private Status status;
    private Severity severity;

    public Defect(String resume, Severity severity, int daysToFix, Attachment attachment, Status status) {
        this.resume = resume;
        this.severity = severity;
        this.daysToFix = daysToFix;
        this.attachment = attachment;
        this.status = status;
        id = currentID++;
    }

    public void setResume(String resume){
        this.resume=resume;
    }

    public void setSeverity(Severity severity){
        this.severity=severity;
    }

    public void setDaysToFix(int daysToFix){
        this.daysToFix=daysToFix;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getResume(){
        return resume;
    }

    public Severity getSeverity(){
        return severity;
    }

    public int getDaysToFix(){
        return daysToFix;
    }

    public long getID() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public String toString(){
        return "ID: " + getID() + " | Резюме: " + getResume() + " | Критичность: " + getSeverity() + " | Дни: " +
                getDaysToFix() + " | Статус: " + getStatus() + " | Вложение: " + getAttachment().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Defect defect = (Defect) o;
        if (this.hashCode() != defect.hashCode()) return false;
        return this.id == defect.id && this.resume.equals(defect.resume) && this.daysToFix == defect.daysToFix &&
                this.attachment.equals(defect.attachment) && this.status.equals(defect.status) &&
                this.severity.equals(defect.severity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, resume, daysToFix, attachment, status, severity);
    }
}
