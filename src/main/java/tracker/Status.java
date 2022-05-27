package tracker;

public enum Status {

    OPEN("Открыто"),
    IN_PROGRESS("В работе"),
    IN_TESTING ("В тестировании"),
    CLOSED("Закрыто");

    String name;

    Status(String name) {
        this.name = name;
    }


}
