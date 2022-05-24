package tracker;

import java.util.Objects;

public class Transition {
    private Status from;
    private Status to;

    public Transition(Status from, Status to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Transition tr = (Transition) o;
        return from == tr.from && to == tr.to;
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }

}



