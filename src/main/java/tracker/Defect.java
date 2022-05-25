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

    public Status getStatus() {
        return status;
    }

    public long getId() {
        return id;
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
        return id == defect.id &&
                this.amountOfDays == defect.amountOfDays &&
                this.description.equals(defect.description) &&
                this.severity.equals(defect.severity) &&
                this.attachment.equals(defect.attachment) &&
                this.status.equals(defect.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, severity, amountOfDays, attachment, status);
    }

}
