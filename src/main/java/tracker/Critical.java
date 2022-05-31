package tracker;

public enum Critical {

    CRITICAL ("критический"),
    HIGH ("высокий"),
    MEDIUM("средний"),
    LOW("низкий");


    String ruNameCritical;
    Critical(String ruNameCritical) {
        this.ruNameCritical = ruNameCritical;
    }

    public String getRuNameCritical() {
        return ruNameCritical;
    }

}
