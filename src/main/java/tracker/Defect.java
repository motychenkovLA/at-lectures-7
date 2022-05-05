package tracker;

public class Defect {
    long id;
    String resume;
    String critical;
    int dayToRepair;

    public Defect(long id, String resume, String critical, int dayToRepair) {
        this.id = id;
        this.resume = resume;
        this.critical = critical;
        this.dayToRepair = dayToRepair;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getCritical() {
        return critical;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }

    public int getDayToRepair() {
        return dayToRepair;
    }

    public void setDayToRepair(int dayToRepair) {
        this.dayToRepair = dayToRepair;
    }

    public static void main(String[] args) {

    }
}