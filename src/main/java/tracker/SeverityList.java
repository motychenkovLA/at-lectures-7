package tracker;

public enum SeverityList {
    BLOCKER("Блокирующий"),
    HIGH("Высокий"),
    MEDIUM("Средний"),
    LOW("Низкий");
    String name;

    SeverityList(String name) {
        this.name = name;
    }
}
