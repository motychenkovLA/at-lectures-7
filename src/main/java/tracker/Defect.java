package tracker;

public class Defect {

    int amountOfDays;
    String description;
    String severity;
    long idDefect;
    static long counter = 1;

    public Defect(String description, String severity, int amountOfDays) {
        this.description = description;
        this.severity = severity;
        this.amountOfDays = amountOfDays;
        this.idDefect = counter;
        counter++;
    }

    public int getAmountOfDays() {
        return amountOfDays;
    }

    public String getDescription() {
        return description;
    }

    public String getSeverity() {
        return severity;
    }

    public long getIdDefect() {
        return idDefect;
    }

    public void setAmountOfDays(int amountOfDays) {
        this.amountOfDays = amountOfDays;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setIdDefect(long idDefect) {
        this.idDefect = idDefect;
    }

    public String toString() {
        return "Номер дефекта: " + idDefect + ", Название: " + description + ", Критичность: "
                + severity + ", Кол-во дней: " + amountOfDays;
    }
}
