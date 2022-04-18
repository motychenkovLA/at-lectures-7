package tracker;

public class Repository {
    static final int LENGTH_ARRAY = 1;
    static Defect[] listDefect = new Defect[LENGTH_ARRAY];
    static int counterArray = 0;

    public static void addDef(Defect defect) {
        listDefect[counterArray] = defect;
        counterArray++;

    }
}
