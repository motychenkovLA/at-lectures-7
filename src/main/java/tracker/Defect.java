package tracker;

public class Defect {
    private static long num = 0L;

    private long id;
    private String summary;
    private String severity;
    private int day;
    private Attachment attach;

    public Defect(String summary, String severity, int day, long attD) {
        this.id = ++num;
        this.summary = summary;
        this.severity = severity;
        this.day = day;
        DefectAttachment attDef = new DefectAttachment(attD);
        this.attach = attDef;
    }

    public Defect(String summary, String severity, int day, String attach) {
        this.id = ++num;
        this.summary = summary;
        this.severity = severity;
        this.day = day;
        CommentAttachment attComent = new CommentAttachment(attach);
        this.attach = attComent;
    }

    public Defect(String summary, String severity, int day) {
        this.id = ++num;
        this.summary = summary;
        this.severity = severity;
        this.day = day;
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

    public int getDay() {
        return day;
    }

    public String getAttach() {
        if (attach != null) {
            return attach.asString();
        } else return "нет вложений";
    }

    public String toString() {
        String s=this.id + " | " + this.summary + " | " + this.severity + " | " + this.day + " | " + this.getAttach();
        return s;
    }
}
