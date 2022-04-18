package tracker;

public class Defect {
    long defectID;
    String resume;
    String severity;
    String daysToFix;

    public Defect(long defectID, String resume, String severity, String daysToFix) {
        this.defectID = defectID;
        this.resume = resume;
        this.severity = severity;
        this.daysToFix = daysToFix;
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

    public void setId(long defectID) {
        this.defectID = defectID;
    }

    public String getResume(){
        return resume;
    }

    public String getSeverity(){
        return severity;
    }

    public String getDaysToFix(){
        return daysToFix;
    }

    public long getDefectID() {
        return defectID;
    }

}
