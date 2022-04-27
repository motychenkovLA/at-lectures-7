package tracker;

public class Defect {
    private final long ID;
    private final int WEEK = 5;
    private String summary;
    private int countDay;
    private Criticality criticality;
    private Attachment attachment;
    private Status status;
    private static long numberDefects = 1;

    public Defect(String summary, Criticality criticality, int countDay) {
        this.summary = summary;
        this.criticality = criticality;
        this.countDay = countDay;
        this.status = Status.OPEN;
        this.ID = numberDefects++;
    }

    public Defect(String summary, Criticality criticality, int countDay, Attachment attachment) {
        this(summary, criticality, countDay);
        this.attachment = attachment;
    }

    public long getID() {
        return ID;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String toString() {
        return attachment == null ? "Defect:"+"\nid = "+ ID +"\nРезюме = "+summary+"\nКритичность = "+criticality.getName()+"\ncountDay = "+countDay+
                    "\nИсправление займет больше рабочей недели = "+(countDay > WEEK)+"\nСтатус = "+status.getTranslation()+"\n":
                "Defect:"+"\nid = "+ ID +"\nРезюме = "+summary+"\nКритичность = "+criticality.getName()+"\ncountDay = "+countDay+
               "\nИсправление займет больше рабочей недели = "+(countDay > WEEK)+"\nСтатус = "+status.getTranslation()+"\n"+attachment;
    }
}




