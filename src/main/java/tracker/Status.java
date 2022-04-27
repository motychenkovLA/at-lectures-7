package tracker;

public enum Status {
    OPEN("Открыто"), IN_PROCESS("В работе"), TEST("Тестирование"), CLOSE("Закрыто"), DONE("Выполненно");

    private String translationStatus;

    Status(String translation) {
        this.translationStatus = translation;
    }

    public String getTranslationStatus() {
        return translationStatus;
    }
}
