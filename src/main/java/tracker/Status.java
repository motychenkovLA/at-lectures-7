package tracker;

public enum Status {

    OPEN("Открыт"),
    CLOSED("Закрыт");

    String ruName;

    Status(String ruName) {
        this.ruName = ruName;
    }
}
