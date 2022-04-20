package tracker;

public class Defect {

    final int WORKING_DAYS_IN_WEEK = 5;     // Рабочая неделя
    static int iteration = 1;
    String resume;
    String critical;
    int dayToFix;
    long id;

    public Defect(String resume, String critical, int dayToFix) {
        this.resume = resume;
        this.critical = critical;
        this.dayToFix = dayToFix;
        id = iteration;
        iteration++;
    }

    public void add(Defect[] bugs, Defect defect) {

        bugs[iteration-1] = defect;

    }

    public String list() {
        return "id дефекта " + id + ":" +
                "\n Описание дефекта: " + resume +
                "\n Критичность: " + critical +
                "\n Количество дней на исправление: " + dayToFix +
                "\n Будет исправлен за рабочую неделю: " + (dayToFix <= WORKING_DAYS_IN_WEEK) +
                "\n________________________________________________________";

    }
}
