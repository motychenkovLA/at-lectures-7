package tracker;

public class Defect {

    private static int count = 0;
    private final long id;

    private String summary;
    private String severity;
    private int days;

    public Defect(String summary, String severity, int days) {
        this.summary = summary;
        this.severity = severity;
        this.days = days;
        id = count++;
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
