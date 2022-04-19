package tracker;

public class Defect {
    private static long numberDefects = 1;
    private final long ID;
    private final int WEEK = 5;
    private String summary;
    private String criticality;
    private int countDay;

    public Defect(String summary, String criticality, int countDay) {
        this.summary = summary;
        this.criticality = criticality;
        this.countDay = countDay;
        this.ID = numberDefects++;
    }

    public String info() {
        return "Defect:"+"\nid = "+ ID +"\nРезюме = "+summary+"\nКритичность = "+criticality+"\ncountDay = "+countDay+
               "\nИсправление займет больше рабочей недели = "+(countDay > WEEK);
    }
}




