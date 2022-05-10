package tracker;

public enum Severity {

    BLOCKER("Блокирующий"),
    CRITICAL("Критический"),
    MAJOR("Значительный"),
    MINOR("Незначительный"),
    TRIVIAL("Тривиальный");

    String ruName;

    Severity(String ruName) {
        this.ruName = ruName;
    }
}
