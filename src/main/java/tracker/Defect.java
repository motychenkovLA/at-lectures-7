package tracker;

import java.util.Objects;

public class Defect {
    private static long counter = 1;
    private int amountOfDays;
    private String description;
    private Severity severity;
    private final long id;
    private Attachment attachment;
    private Status status;

    public Defect(String description, Severity severity, int amountOfDays, Attachment attachment) {
        this.description = description;
        this.severity = severity;
        this.amountOfDays = amountOfDays;
        this.id = counter;
        this.attachment = attachment;
        this.status = Status.OPEN;
        counter++;
    }

    public String getDescription() {
        return description;
    }

    public Severity getSeverity() {
        return severity;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {

        this.status = status;
    }

    public String toString() {
        return "Номер дефекта: " + id + ", Название: " + description + ", Критичность: "
                + severity + ", Кол-во дней: " + amountOfDays + " , " + attachment.asString() + " , Статус " +
                status.getRuName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Defect defect = (Defect) o;
        if (this.hashCode() != defect.hashCode()) return false; // todo 3 - лишняя проверка
        return id == defect.id &&
                this.amountOfDays == defect.amountOfDays &&
                this.equals(defect.getDescription()) && // todo 5 - дефект никогда не может быть равен строке
                this.equals(defect.getSeverity()) && // todo 5 - дефект никогда не может быть раен критичности
                this.equals(defect.getAttachment()) && // todo 5 - дефект никогда не может быть раен аттачменту
                this.equals(defect.getStatus()); // todo 5 - дефект никогда не может быть раен статусу

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, severity, amountOfDays, attachment, status);
    }

}
