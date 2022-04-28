package tracker;

public class Defect {
    private final long id;
    private String name;
    private String critical;
    private int countDay;
    private static long counter = 1;
    private Attachment attachment;

    public Defect(String name, String critical, int countDay, Attachment attachment) {
        this.name = name;
        this.critical = critical;
        this.countDay = countDay;
        this.id = counter;
        this.attachment = attachment;
        counter++;
    }

    public String info() {
        return "Номер дефекта: " + id + ", Название: " + name + ", Критичность: "
                + critical + ", Кол-во дней: " + countDay + " , " + attachment.asString();
    }
}