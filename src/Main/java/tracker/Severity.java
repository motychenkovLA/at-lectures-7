package tracker;

public enum Severity {
    TRIVIAL("trivial"),
    MINOR("minor"),
    MAJOR("major"),
    CRITICAL("critical"),
    BLOCKER("blocker");

    private final String name;

    Severity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
