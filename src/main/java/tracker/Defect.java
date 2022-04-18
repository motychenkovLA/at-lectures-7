package tracker;

public class Defect {
    private static long numberDefects = 1;
    private final long ID_DEFECT;
    private final int WEEK = 5;
    private String summary;
    private String criticality;
    private int countDay;

    public Defect(String summary) {
        this.summary = summary;
        ID_DEFECT = numberDefects++;
    }

    public void setCriticality(String criticality) {
        if (criticality.equals("trivial") || criticality.equals("minor") ||
                criticality.equals("major") || criticality.equals("critical") ||
                criticality.equals("blocker")) {
            this.criticality = criticality;
        }else {
            this.criticality = "minor";
        }
    }

    public void setCountDay(int countDay) {
        this.countDay = countDay;
    }

    public String info() {
        return "Defect:"+"\nid = "+ ID_DEFECT +"\nРезюме = "+summary+"\nКритичность = "+criticality+"\ncountDay = "+countDay+
               "\nИсправление займет больше рабочей недели = "+(countDay > WEEK);
    }
}




