package tracker;

public enum Severity {

    BLOCKER("Блокирующий"),
    CRITICAL("Критический"),
    MAJOR("Значительный"),
    MINOR("Незначительный"),
    TRIVIAL("Тривиальный");

    final String ruName;

    Severity(String ruName) {
        this.ruName = ruName;
    }

}
