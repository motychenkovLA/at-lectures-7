package tracker;

public class Defect {

    private final int WORKING_DAYS_IN_WEEK = 5;     // Рабочая неделя
    private final long ID;
    private static int iteration = 1;
    private String resume;
    private String critical;
    private int dayToFix;


    public Defect(String resume, String critical, int dayToFix) {
        this.resume = resume;
        this.critical = critical;
        this.dayToFix = dayToFix;
        ID = iteration;
        iteration++;
    }


    public String getResume() {
        return resume;
    }

    public String getCritical() {
        return critical;
    }

    public int getDayToFix() {
        return dayToFix;
    }

    public String list() {
        return "id дефекта " + ID + ":" +
                "\n Описание дефекта: " + resume +
                "\n Критичность: " + critical +
                "\n Количество дней на исправление: " + dayToFix +
                "\n Будет исправлен за рабочую неделю: " + (dayToFix <= WORKING_DAYS_IN_WEEK) +
                "\n________________________________________________________";

    }
}
