package tracker;

public class Defect {
    private static long numberDefects = 1;
    private final long ID_DEFECT;
    {
        ID_DEFECT = numberDefects++;
    }
    private final int WEEK = 5;
    private String summary;
    private String criticality;
    private int countDay;

    public Defect(String summary) {
        this.summary = summary;
    }

    public void setCriticality(String criticality) {
        if (criticality.equals("trivial") || criticality.equals("minor") ||
                criticality.equals("major") || criticality.equals("critical") ||
                criticality.equals("blocker")) {
            this.criticality = criticality;
        } else {
            this.criticality = "minor";
        }
    }

    public void setCountDay(int countDay) {
        if (countDay <= 0) {
            this.countDay = 1;
        } else {
            this.countDay = countDay;
        }
    }

    public String info() {
        return "Defect:"+"\nid = "+ ID_DEFECT +"\nРезюме = "+summary+"\nКритичность = "+criticality+"\ncountDay = "+countDay+
               "\nИсправление займет больше рабочей недели = "+(countDay > WEEK);
    }
}




