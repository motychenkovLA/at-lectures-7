package tracker;

public class Defect {
    private final long id;
    private String name;
    private String critical;
    private int countDay;
    private static long counter = 1;

    public Defect(String name, String critical, int countDay) {
        this.name = name;
        this.critical = critical;
        this.countDay = countDay;
        this.id = counter;
        counter++;
    }

    public String info() {
        return "Номер дефекта: " + id + ", Название: " + name + ", Критичность: "
                + critical + ", Кол-во дней: " + countDay;
    }
}