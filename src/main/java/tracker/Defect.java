package tracker;


public class Defect {
    private final long id;
    private String resume;
    private String daysToFix;
    private static long currentID = 1;
    private Attachment attachment;
    private Status status;
    private Severity severity;

    public Defect(String resume, Severity severity, String daysToFix, Attachment attachment, Status status) {
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

    public void setDaysToFix(String daysToFix){
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

    public String getDaysToFix(){
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
}
