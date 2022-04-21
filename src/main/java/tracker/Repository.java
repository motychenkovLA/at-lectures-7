package tracker;

import java.util.Arrays;

public class Repository {
    private int length;
    private static Defect[] listDefect;
    private static int counterArray = 0;

    public Repository(int length) {
        this.length = length;
        listDefect = new Defect[length];
    }

    public static boolean examination() {
        if(getCounterArray() >= listDefect.length) {
            return true;
        }
        return false;
    }

    public static void addDef(Defect defect) {
        listDefect[counterArray] = defect;
        counterArray++;
    }

    public static int getCounterArray() {
        return counterArray;
    }

    public static Defect[] getAll() {
        Defect[] copyListDefect = Arrays.copyOf(listDefect, counterArray);
        return copyListDefect;
    }
}
