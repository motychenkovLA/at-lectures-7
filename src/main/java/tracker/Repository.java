package tracker;

public class Repository {
    private static final int MAX_DEFECT_SIZE = 10;
    private static Defect[] listDefect = new Defect[MAX_DEFECT_SIZE];
    private static int counterDefectSize = 0;

    public static Defect[] getListDefect() {
        return listDefect;
    }

    public static int getCounterDefectSize() {
        return counterDefectSize;
    }

    public static void add(Defect defect) {
        listDefect[counterDefectSize] = defect;
        counterDefectSize++;
    }

    public static Defect[] getAll() {
        return listDefect;
    }

}
