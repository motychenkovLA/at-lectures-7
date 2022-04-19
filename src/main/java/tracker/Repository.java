package tracker;

public class Repository {
    private static final int LENGTH_ARRAY = 10;
    private static Defect[] listDefect = new Defect[LENGTH_ARRAY];
    private static int counterArray = 0;

    public static Defect[] getListDefect() {
        return listDefect;
    }

    public static int getCounterArray() {
        return counterArray;
    }

    public static void addDef(Defect defect) {
        listDefect[counterArray] = defect;
        counterArray++;
    }

    public static Defect[] getAll() {
        return listDefect;

    }
}
