package tracker;

public class Defect {
    private final long id;
    private String resume;
    private String severity;
    private String daysToFix;
    private static long currentID = 1;
    private Attachment attachment;

    public Defect(String resume, String severity, String daysToFix, Attachment attachment) {
        this.resume = resume;
        this.severity = severity;
        this.daysToFix = daysToFix;
        this.attachment = attachment;
        id = currentID++;
    }

    public void setResume(String resume){
        this.resume=resume;
    }

    public void setSeverity(String severity){
        this.severity=severity;
    }

    public void setDaysToFix(String daysToFix){
        this.daysToFix=daysToFix;
    }


    public String getResume(){
        return resume;
    }

    public String getSeverity(){
        return severity;
    }

    public String getDaysToFix(){
        return daysToFix;
    }

    public long getID() {
        return id;
    }

    public Attachment getAttachment() {
        return attachment;
    }
}
