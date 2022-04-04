package tracker;

public class Defect {
    private final int WEEK = 5;
    private int numberDefect;
    private static int i = 0;
    private String summary;
    private String criticality;
    private int countDay;

    public Defect(String summary, String criticality, int countDay) {
        this.summary = summary;
        this.criticality = criticality;
        this.countDay = countDay;
        numberDefect = i++;
    }

    public int getNumberDefect() {
        return numberDefect;
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
        return "Defect:"+"\nНомер = "+numberDefect+"\nРезюме = "+summary+"\nКритичность = "+criticality+"\ncountDay = "+countDay+
                "\nИсправление займет больше рабочей недели = "+(countDay > WEEK);
    }
}




