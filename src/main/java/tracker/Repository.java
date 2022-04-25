package tracker;

import java.util.Arrays;

public class Repository {
    private Defect[]listDefect;
    private int counterArray = 0;

    public Repository(int length) {
        listDefect = new Defect[length];
    }

    public boolean isExamination() {
        if(counterArray >= listDefect.length) {
            return true;
        }
        return false;
    }

    public void addDef(Defect defect) {
        listDefect[counterArray] = defect;
        counterArray++;
    }

    public int getCounterArray() {
        return counterArray;
    }

    public Defect[] getAll() {
        Defect[] copyListDefect = Arrays.copyOf(listDefect, counterArray);
        return copyListDefect;
    }
}
