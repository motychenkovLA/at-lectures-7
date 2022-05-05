package tracker;

public class Defect {
    private static long num = 0L;

    private long id;
    private String summary;
    private SeverityList severity;
    private int day;
    private Attachment attach;
    private StatusList status;

    public Defect(String summary, SeverityList severity, int day, long attD) {
        this.id = ++num;
        this.summary = summary;
        this.severity = severity;
        this.day = day;
        DefectAttachment attDef = new DefectAttachment(attD);
        this.attach = attDef;
        this.status = StatusList.OPEN;
    }

    public Defect(String summary, SeverityList severity, int day, String attach) {
        this.id = ++num;
        this.summary = summary;
        this.severity = severity;
        this.day = day;
        CommentAttachment attComent = new CommentAttachment(attach);
        this.attach = attComent;
        this.status = StatusList.OPEN;
    }

    public Defect(String summary, SeverityList severity, int day) {
        this.id = ++num;
        this.summary = summary;
        this.severity = severity;
        this.day = day;
        this.status = StatusList.OPEN;
    }

    public long getId() {
        return id;
    }

    public String getSummary() {
        return summary;
    }

    public String getSeverity() {
        return severity.name();
    }

    public int getDay() {
        return day;
    }

    public String getAttach() {
        if (attach != null) {
            return attach.toString();
        } else return "нет вложений";
    }

    @Override
    public String toString() {
        String s = this.id + " | " + this.status.name + " | " + this.summary + " | " + this.severity.name + " | " + this.day + " | " + this.getAttach();
        return s;
    }

    public void changeStatus(StatusList status) {
        this.status = status;

    }
}
