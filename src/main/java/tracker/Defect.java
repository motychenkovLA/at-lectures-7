package tracker;

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

    public void setId(long id) {
        this.id = id;
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
}
