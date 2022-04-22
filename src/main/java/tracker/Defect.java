package tracker;

public class Defect {
    private final long id;
    private String resume;
    private String severity;
    private String daysToFix;
    private static long currentID = 1;

    public Defect(String resume, String severity, String daysToFix) {
        this.resume = resume;
        this.severity = severity;
        this.daysToFix = daysToFix;
        id = currentID++;
    }

    public void setResume(String resume){
        this.resume=resume;
    }

    public void setSeverity(String severity){
        this.severity=severity;
    }

    public void setDaysToFix(String daysToFix){
        this.daysToFix=daysToFix;
    }

//    public void setID(long id) {
//        this.id = id;
//    }

    public String getResume(){
        return resume;
    }

    public String getSeverity(){
        return severity;
    }

    public String getDaysToFix(){
        return daysToFix;
    }

    public long getID() {
        return id;
    }

}
