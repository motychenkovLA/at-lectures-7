package tracker;

public enum Severity {

    BLOCKER("�����������"),
    CRITICAL("�����������"),
    MAJOR("������������"),
    MINOR("��������������"),
    TRIVIAL("�����������");

    String ruName;

    Severity(String ruName) {
        this.ruName = ruName;
    }
}
