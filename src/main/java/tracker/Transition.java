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
        Transition transition = (Transition) o;
        if (this.hashCode() != transition.hashCode()) return false;
        return this.from.equals(transition.from) && this.to == transition.to;
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }
}
