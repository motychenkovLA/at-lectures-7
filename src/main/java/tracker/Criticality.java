package tracker;

public enum Criticality {
    TRIVIAL("trivial"),
    MINOR("minor"),
    MAJOR("major"),
    CRITICAL("critical"),
    BLOCKER("blocker");

    private String name;

    Criticality(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
