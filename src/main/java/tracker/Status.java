package tracker;

public enum Status {

    OPEN("Открыто"),
    IN_PROGRESS("В работе"),
    CLOSED("Закрыто");

    String name;

    Status(String name) {
        this.name = name;
    }


}
