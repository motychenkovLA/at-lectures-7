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
        if (!(o instanceof Transition)) return false;
        Transition that = (Transition) o;
        return from == that.from && to == that.to;
    }

    @Override
    public int hashCode() {
        return from.toString().hashCode() + to.toString().hashCode();

    }
}
