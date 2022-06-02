package tracker;

import java.util.Objects;

public class Defect {
    private final long id;
    private static int iteration = 1;
    private String resume;
    private Critical critical;
    private int dayToRepair;
    private Status status;
    private Attachment attachment;

    public Defect(String resume, Critical critical, int dayToRepair, Attachment attachment) {
        this.status = Status.OPEN;
        this.resume = resume;
        this.critical = critical;
        this.dayToRepair = dayToRepair;
        this.attachment = attachment;
        id = iteration;
        iteration++;
    }

    public int getDayToRepair(){
        return dayToRepair;
    }

    public long getId() {
        return id;
    }

    public void setStatus(Status status) {

        this.status = status;
    }

    public  Status getStatus() {
        return status;
    }

    public String toString() {
        return id + " | " + status.getRuNameStatus() + " | " + resume + " | " + critical.getRuNameCritical() +
                " | " + " дней на исправление: "
                + dayToRepair + attachment.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Defect defect = (Defect) o;
        return id == defect.id &&
                this.dayToRepair == defect.dayToRepair &&
                this.resume.equals(defect.resume) &&
                this.critical.equals(defect.critical) &&
                this.attachment.equals(defect.attachment) &&
                this.status.equals(defect.status);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, resume, critical, dayToRepair, status, attachment);
    }
}