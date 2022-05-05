package tracker;

public enum Statuses {

    OPEN("Открыто"),
    IN_PROGRESS ("В работе"),
    CLOSED("Закрыто");

    String name;

    Statuses(String name) {
        this.name = name;
    }


}
