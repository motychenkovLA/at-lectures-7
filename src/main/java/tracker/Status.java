package tracker;

public enum Status {
    OPEN ("Открыто"),
    IN_PROCESS ("В работе"),
    TEST ("Тестирование"),
    DONE ("Выполнено");

    private String translation;
    Status (String translation) {
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }
}
