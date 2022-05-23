package tracker;

public enum Status {
    OPEN("ОТКРЫТ"),
    IN_PROGRESS("В РАБОТЕ"),
    READY_FOR_TESTING("ГОТОВ К ТЕСТИРОВАНИЮ"),
    TESTING("ТЕСТИРОВАНИЕ"),
    DONE("СДЕЛАНО"),
    CLOSED("ЗАКРЫТ");

    private final String ruName;

    Status(String ruName) {
        this.ruName = ruName;
    }

    public String getRuName() {
        return ruName;
    }
}