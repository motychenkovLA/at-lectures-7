package tracker;

public class Defect {
    private final int WEEK = 5;
    private long idDefect;
    private static long numberDefects = 1;
    private String summary;
    private String criticality;
    private int countDay;

    public Defect(String summary, String criticality, int countDay) {
        this.summary = summary;
        this.criticality = criticality;
        this.countDay = countDay;
        idDefect = numberDefects++;
    }

    public long getNumberDefect() {
        return idDefect;
    }

    public String getSummary() {
        return summary;
    }

    public String getCriticality() {
        return criticality;
    }

    public int getCountDay() {
        return countDay;
    }

    @Override
    public String toString() {
        return "Defect:"+"\nid = "+idDefect+"\nРезюме = "+summary+"\nКритичность = "+criticality+"\ncountDay = "+countDay+
                "\nИсправление займет больше рабочей недели = "+(countDay > WEEK);
    }
}




