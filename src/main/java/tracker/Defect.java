package tracker;

public class Defect {
    private final long id;
    private static int iteration = 1;
    private String resume;
    private String critical;
    private int dayToRepair;
    private Attachment attachmentMein;

    public Defect(String resume, String critical, int dayToRepair, Attachment attachment) {
        this.resume = resume;
        this.critical = critical;
        this.dayToRepair = dayToRepair;
        this.attachmentMein = attachment;
        id = iteration;
        iteration++;
    }


    public String list() {
        return id + " | " + resume + " | " + critical + " | " + " дней на исправление: " + dayToRepair +
                attachmentMein.asString();
    }

}