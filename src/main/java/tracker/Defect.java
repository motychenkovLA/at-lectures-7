package tracker;

public class Defect {
    private long id;
    // todo 1 - поля и так в дефекте, нет смысла указывать в названии defect
    private String nameDefect;
    private String criticalDefect;
    private int countDayDefect;
    private static long counter = 1;

    // todo 3 - дефект создается в невалидном состоянии: без резюме и критичности, с 0 дней на исправление
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
