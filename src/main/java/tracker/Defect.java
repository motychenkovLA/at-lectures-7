package tracker;

public class Defect {
    private final long id;
    private static int iteration = 1;
    private String resume;
    private String critical;
    private int dayToRepair;

    public Defect(String resume, String critical, int dayToRepair) {
        this.resume = resume;
        this.critical = critical;
        this.dayToRepair = dayToRepair;
        id = iteration;
        iteration++;
    }

    public String list() {
        return id + " | " + resume + " | " + critical + " | " + dayToRepair + " дня";
    }
}