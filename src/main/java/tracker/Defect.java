package tracker;

public class Defect {

    private final int WORKING_DAYS_IN_WEEK = 5;     // Рабочая неделя
    private int ID;
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
        ID = iteration;
        iteration++;
    }

    public Defect(String resume, Critical critical, int dayToFix, Attachment attachment) {
        this(resume, critical, dayToFix);
        this.attachment = attachment;
    }

    public String getResume() {
        return resume;
    }

    public int getDayToFix() {
        return dayToFix;
    }

    public int getID() {
        return ID;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String toString() {
        return attachment == null ? "id дефекта " + ID + ":" +
                "\n Описание дефекта: " + resume +
                "\n Критичность: " + critical +
                "\n Количество дней на исправление: " + dayToFix +
                "\n Будет исправлен за рабочую неделю: " + (dayToFix <= WORKING_DAYS_IN_WEEK) +
                "\n Статус: " + status.getTranslation() +
                "\n________________________________________________________"
                :
                "id дефекта " + ID + ":" +
                        "\n Описание дефекта: " + resume +
                        "\n Критичность: " + critical +
                        "\n Количество дней на исправление: " + dayToFix +
                        "\n Будет исправлен за рабочую неделю: " + (dayToFix <= WORKING_DAYS_IN_WEEK) +
                        "\n Статус: " + status.getTranslation() +
                        "\n Вложения: " + attachment +
                        "\n________________________________________________________";

    }
}
