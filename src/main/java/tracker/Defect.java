package tracker;

public class Defect {
    private final long ID;
    private final int WEEK = 5;
    private String summary;
    private String criticality;
    private int countDay;
    private Attachment attachment;
    private static long numberDefects = 1;

    public Defect(String summary, String criticality, int countDay) {
        this.summary = summary;
        this.criticality = criticality;
        this.countDay = countDay;
        this.ID = numberDefects++;
    }

    public Defect(String summary, String criticality, int countDay, Attachment attachment) {
        this.summary = summary;
        this.criticality = criticality;
        this.countDay = countDay;
        this.attachment = attachment;
        this.ID = numberDefects++;
    }

    public String toString() {
        if (attachment == null) {
            return "Defect:"+"\nid = "+ ID +"\nРезюме = "+summary+"\nКритичность = "+criticality+"\ncountDay = "+countDay+
                    "\nИсправление займет больше рабочей недели = "+(countDay > WEEK);
        }
        return "Defect:"+"\nid = "+ ID +"\nРезюме = "+summary+"\nКритичность = "+criticality+"\ncountDay = "+countDay+
               "\nИсправление займет больше рабочей недели = "+(countDay > WEEK)+"\n"+attachment.asString();
    }
}




