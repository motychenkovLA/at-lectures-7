package tracker;

public enum Severity {

    BLOCKER("�����������"),
    CRITICAL("�����������"),
    MAJOR("������������"),
    MINOR("��������������"),
    TRIVIAL("�����������");

    final String ruName;

    Severity(String ruName) {
        this.ruName = ruName;
    }

}
