package tracker;

public enum Status {

    OPEN ("открыт"),
    ANALIS("анализ"),
    DEVELOP("разработка"),
    TESTING("тестирование"),
    CLOSED("закрыт");

    String ruNameStatus;
    Status(String ruNameStatus) {
        this.ruNameStatus = ruNameStatus;
    }

    public String getRuNameStatus() {
        return ruNameStatus;
    }
}
