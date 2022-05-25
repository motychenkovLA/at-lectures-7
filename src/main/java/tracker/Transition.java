package tracker;

import java.util.Objects;

public class Transition {
    private final Status from;
    private Status to; // todo 3 - можно зафиналить

    public Transition(Status from, Status to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Transition that = (Transition) o;
        return from == that.from && to == that.to;
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }
}
