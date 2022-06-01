package tracker;

public enum Status {

    OPEN ("открыт"),
    ANALISYS("в анализе"),
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
