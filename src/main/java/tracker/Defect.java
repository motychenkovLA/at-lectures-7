package tracker;

public class Defect {

    private int amountOfDays;
    private String description;
    private String severity;
    private final long idDefect;
    private static long counter = 1;

    public Defect(String description, String severity, int amountOfDays) {
        this.description = description;
        this.severity = severity;
        this.amountOfDays = amountOfDays;
        this.idDefect = counter;
        counter++;
    }

    public String toString() {
        return "Номер дефекта: " + idDefect + ", Название: " + description + ", Критичность: "
                + severity + ", Кол-во дней: " + amountOfDays;
    }
}
