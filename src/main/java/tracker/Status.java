package tracker;

public enum Status {

    OPEN("Открыт"),
    ANALYSIS("В анализе"),
    FIXED("Исправление"),
    TEST("Тестирование"),
    CLOSED("Закрыт");

    String ruName;

    Status(String ruName) {
        this.ruName = ruName;
    }
}
