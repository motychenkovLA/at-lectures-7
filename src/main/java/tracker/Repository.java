package tracker;

import java.util.Arrays;

public class Repository {
    private int size;
    private static Defect[] listDefect;
    private static int counterDefectSize = 0;

    public Repository(int size) {
        this.size = size;
        listDefect = new Defect[size];
    }

    public static boolean maxSize() {
        return getCounterDefectSize() >= listDefect.length;
    }

    public static int getCounterDefectSize() {
        return counterDefectSize;
    }

    public static void add(Defect defect) {
        listDefect[counterDefectSize] = defect;
        counterDefectSize++;
    }

    public static Defect[] getAll() {
        return Arrays.copyOf(listDefect, counterDefectSize);
    }
}