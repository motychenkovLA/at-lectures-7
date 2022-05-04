package tracker;

public class Defect {
    private final long id;
    private String name;
    private Severity severity;
    private int countDay;
    private static long counter = 1;
    private Attachment attachment;
    private Status status;

    public Defect(String name, Severity severity, int countDay, Attachment attachment) {
        this.name = name;
        this.severity = severity;
        this.countDay = countDay;
        this.id = counter;
        this.attachment = attachment;
        this.status = Status.OPEN;
        counter++;
    }
    public long getId() {
        return id;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    public String toString() {
        return "Номер дефекта: " + id + ", Название: " + name + ", Критичность: "
                + severity + ", Кол-во дней: " + countDay + " , " + attachment.asString() + ", Статус " +
                status.getRuName();
    }
}