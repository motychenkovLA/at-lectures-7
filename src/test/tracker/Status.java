package tracker;

public enum Status {
    NEW("новый"),
    OPENED("открыт"),
    CLOSED("закрыт");

    private final String ruName;

    public String getRuName(){
        return ruName;
    }

    Status(String ruName) {
        this.ruName = ruName;
    }
}
