package tracker;

public enum Severity {
    BLOCKER("Блокирующий"),
    HIGH("Высокий"),
    MEDIUM("Средний"),
    LOW("Низкий");
    String name;

    Severity(String name) {
        this.name = name;
    }
}
