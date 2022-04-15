package tracker;

// todo 0 - комменты дублируют код
public class Defect {

    int amountOfDays;
    String description;
    String severity;
    long idDefect = 1L; // todo 1 - лишний код

    // todo 3 - дефект существует в невалидном виде: без резюме и критичности, с нулевым временем на исправление
    /*Создание экземпляров класса Defect*/
    public Defect(long id) {

        this.idDefect = id;
    }

    /*метод для возвращения кол-ва дней на исправление*/
    public int getAmountOfDays() {
        return amountOfDays;
    }

    /*метод для возвращения описания*/
    public String getDescription() {
        return description;
    }

    /*метод для возвращения критичности*/
    public String getSeverity() {
        return severity;
    }

    /*метод для возвращения id*/
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
}
