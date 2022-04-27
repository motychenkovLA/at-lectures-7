package tracker;

public enum Criticality {
    TRIVIAL("trivial"), MINOR("minor"), MAJOR("major"), CRITICAL("critical"), BLOCKER("blocker");

    private String translationCritical;

    Criticality(String name) {
        this.translationCritical = name;
    }

    public String getTranslationCritical() {
        return translationCritical;
    }
}
