package tracker;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Transition {

    private final Status from;
    private final Status to;

    private static Set<Transition> set = new HashSet<>();

    public Transition(Status from, Status to) {
        this.from = from;
        this.to = to;
    }

    static {
        set.add(new Transition(Status.OPEN, Status.ANALISYS));
        set.add(new Transition(Status.ANALISYS, Status.DEVELOP));
        set.add(new Transition(Status.DEVELOP, Status.TESTING));
        set.add(new Transition(Status.ANALISYS, Status.CLOSED));
        set.add(new Transition(Status.DEVELOP, Status.CLOSED));
        set.add(new Transition(Status.TESTING, Status.CLOSED));
    }

    public static boolean checkTransition(Status from, Status to){
        return set.contains(new Transition(from, to));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transition that = (Transition) o;
        return from == that.from && to == that.to;
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }
}
