package tracker;

public class Defect {
    private long id;
    private String nameDefect;
    private String criticalDefect;
    private int countDayDefect;
    private static long counter = 1;

    public Defect(String nameDefect) {
        this.nameDefect = nameDefect;
        id = counter;
        counter++;
    }

    public void setCriticalDefect(String criticalDefect) {
        this.criticalDefect = criticalDefect;
    }

    public void setCountDayDefect(int countDayDefect) {
        this.countDayDefect = countDayDefect;
    }
    public String toString() {
        return "Номер дефекта: " + id + ", Название: " + nameDefect + ", Критичность: "
                + criticalDefect + ", Кол-во дней: " + countDayDefect;
    }
}
