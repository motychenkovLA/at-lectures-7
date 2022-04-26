package tracker;

public class Defect {
    private static long counter = 1;
    private int amountOfDays;
    private String description;
    private String severity;
    private final long id;
    private Attachment attachment;

    public Defect(String description, String severity, int amountOfDays, Attachment attachment) {
        this.description = description;
        this.severity = severity;
        this.amountOfDays = amountOfDays;
        this.id = counter;
        this.attachment = attachment;
        counter++;
    }

    public String toString() {
        return "Номер дефекта: " + id + ", Название: " + description + ", Критичность: "
                + severity + ", Кол-во дней: " + amountOfDays + ", Вложение: " + attachment.asString();
    }
}
