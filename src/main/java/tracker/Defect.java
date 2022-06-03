package tracker;

import java.util.Objects;

public class Defect {

    private final int WORKING_DAYS_IN_WEEK = 5;     // Рабочая неделя
    private final long id;
    private static int iteration = 1;
    private String resume;
    private Critical critical;
    private Attachment attachment;
    private int dayToFix;
    private Status status;


    public Defect(String resume, Critical critical, int dayToFix) {
        this.resume = resume;
        this.critical = critical;
        this.dayToFix = dayToFix;
        this.status = Status.OPEN;
        id = iteration;
        iteration++;
    }

    public Defect(String resume, Critical critical, int dayToFix, Attachment attachment) {
        this(resume, critical, dayToFix);
        this.attachment = attachment;
    }

    public long getID() {
        return id;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public String toString() {
        return attachment == null ? "id дефекта " + id + ":" +
                "\n Описание дефекта: " + resume +
                "\n Критичность: " + critical +
                "\n Количество дней на исправление: " + dayToFix +
                "\n Будет исправлен за рабочую неделю: " + (dayToFix <= WORKING_DAYS_IN_WEEK) +
                "\n Статус: " + status.getTranslation() +
                "\n________________________________________________________"
                :
                "id дефекта " + id + ":" +
                        "\n Описание дефекта: " + resume +
                        "\n Критичность: " + critical +
                        "\n Количество дней на исправление: " + dayToFix +
                        "\n Будет исправлен за рабочую неделю: " + (dayToFix <= WORKING_DAYS_IN_WEEK) +
                        "\n Статус: " + status.getTranslation() +
                        "\n Вложения: " + attachment +
                        "\n________________________________________________________";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Defect defect = (Defect) o;
        if (this.hashCode() != o.hashCode()) return false;
        return id == defect.id &&
                dayToFix == defect.dayToFix &&
                resume.equals(defect.resume) &&
                critical == defect.critical &&
                attachment.equals(defect.attachment) &&
                status == defect.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(WORKING_DAYS_IN_WEEK, id, resume, critical, attachment, dayToFix, status);
    }
}
