package tracker;

public enum Status {

    OPEN("������"),
    ANALYSIS("� �������"),
    FIXED("�����������"),
    TEST("������������"),
    CLOSED("������");

    String ruName;

    Status(String ruName) {
        this.ruName = ruName;
    }
}
