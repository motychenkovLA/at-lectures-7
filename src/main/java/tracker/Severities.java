package tracker;

public enum Severities {
    BLOCKER("Блокирующий"),
    HIGH("Высокий"),
    MEDIUM("Средний"),
    LOW("Низкий");
    String name;

    Severities(String name) {
        this.name = name;
    }
}
