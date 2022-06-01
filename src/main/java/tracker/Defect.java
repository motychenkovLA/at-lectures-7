package tracker;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Defect {
    private static long num = 0L;

    private long id;
    private String summary;
    private Severity severity;
    private int day;
    private Attachment attach;
    private Status status;

    public Defect(String summary, Severity severity, int day) {
        this.id = ++num;
        this.summary = summary;
        this.severity = severity;
        this.day = day;
        this.status = Status.OPEN;
    }

    public Defect(String summary, Severity severity, int day, Attachment attach) {
        this(summary, severity, day);
        this.attach = attach;

    }


    public long getId() {
        return id;
    }

    public String getSummary() {
        return summary;
    }

    public String getSeverity() {
        return severity.name();
    }

    public int getDay() {
        return day;
    }

    public Status getStatus() {
        return status;
    }

    public String getAttach() {
        if (attach != null) {
            return attach.toString();
        } else return "нет вложений";
    }

    @Override
    public String toString() {
        String s = this.id + " | " + this.status.name + " | " + this.summary + " | " + this.severity.name + " | " + this.day + " | " + this.getAttach();
        return s;
    }

    public void changeStatus(Status status) {
        this.status = status;

    }

    public boolean checkTransition(Status statusFrom, Status statusTo) {
        Transition checkedTrans = new Transition(statusFrom, statusTo);
        Set<Transition> setTransition = new HashSet<>();

        setTransition.add(new Transition(Status.OPEN, Status.IN_PROGRESS));
        setTransition.add(new Transition(Status.IN_TESTING, Status.CLOSED));
        setTransition.add(new Transition(Status.IN_PROGRESS, Status.IN_TESTING));
        setTransition.add(new Transition(Status.IN_TESTING, Status.IN_PROGRESS));
        setTransition.add(new Transition(Status.CLOSED, Status.IN_TESTING));
        return setTransition.contains(checkedTrans);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Defect defect = (Defect) o;
        if (id == defect.id) return true;
        return day == defect.day &&
                this.summary.equals(defect.summary) && this.severity.ordinal() == defect.severity.ordinal() &&
                this.attach.equals(defect.attach) && this.status.ordinal() == defect.status.ordinal();
    }

    @Override
    public int hashCode() {
        return this.summary.length() + this.severity.ordinal() + this.day + this.attach.toString().length() + this.status.ordinal();
    }


}
