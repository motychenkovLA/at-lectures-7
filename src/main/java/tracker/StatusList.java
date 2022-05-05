package tracker;

public enum StatusList {

    OPEN("Открыто"),
    IN_PROGRESS ("В работе"),
    CLOSED("Закрыто");

    String name;

    StatusList(String name) {
        this.name = name;
    }


}
