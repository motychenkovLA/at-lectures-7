package tracker;

public class Defect {

    private static int count = 0;
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
        this.attachment = attachment;
        id = count++;
        this.status = Status.valueOf("OPEN");
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public long getId() {
        return id;
    }

    public String getSummary() {
        return summary;
    }

    public String getSeverity() {
        return severity;
    }

    public int getDays() {
        return days;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = Status.valueOf(status);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; //проверка рефлексивности
        if (obj == null || obj.getClass() != this.getClass()) return false;//проверка класссов
        Defect defect = (Defect) obj;
        return id == defect.id &&
                days == defect.days &&
                (summary == defect.summary || (summary != null && summary.equals(defect.getSummary()))) &&
                (severity == defect.severity || (severity != null && severity.equals(defect.getSeverity()))) &&
                (attachment == defect.attachment ||
                        (attachment != null && attachment.equals(defect.getAttachment()))) &&
                (status == defect.status || (status != null && status.equals(defect.getStatus())));
        //проверка равенства полей
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = prime + Integer.hashCode((int) id);
        result = prime * result + Integer.hashCode(days);
        result = prime * result + ((summary == null) ? 0 : summary.hashCode());
        result = prime * result + ((severity == null) ? 0 : severity.hashCode());
        result = prime * result + ((attachment == null) ? 0 : attachment.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        return result;
    }
}