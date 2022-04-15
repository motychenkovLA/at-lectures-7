package tracker;

public class ListDefect {
    static final int ARRAY_SIZE = 10;
    static Defect[] listDefect = new Defect[ARRAY_SIZE];
    static int counter = 0;

    public static void list(Defect defect) {
        listDefect[counter] = defect;
        counter++;
    }
}
