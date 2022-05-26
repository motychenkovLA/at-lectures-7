package tracker;

import java.util.*;

public class Transition {
    private final Status from;
    private final Status to;

    private static Set<Transition> set = new HashSet<>();

    public Transition(Status from, Status to) {
        this.from = from;
        this.to = to;
    }

    static {
        set.add(new Transition(Status.OPEN, Status.IN_PROGRESS));
        set.add(new Transition(Status.IN_PROGRESS, Status.READY_FOR_TESTING));
        set.add(new Transition(Status.READY_FOR_TESTING, Status.TESTING));
        set.add(new Transition(Status.TESTING, Status.DONE));
        set.add(new Transition(Status.IN_PROGRESS, Status.CLOSED));
    }

    public static boolean checkTransition(Status from, Status to){
        return set.contains(new Transition(from, to));
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
