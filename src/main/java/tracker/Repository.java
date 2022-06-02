package tracker;

import java.util.Arrays;

public class Repository {

    private final int SIZE = 10;
    private Defect[] list = new Defect[SIZE];
    private int counter = 0;

    public boolean isComplet() {
        if (counter >= SIZE) {
            return true;
        }
        return false;
    }

    public void addDefect(Defect defect) {
        list[counter] = defect;
        counter++;
    }

    public Defect[] getAll() {
        Defect[] copyListDefect = Arrays.copyOf(list, counter);
        return copyListDefect;
    }

    public int getCounterArray() {
        return counter;
    }

}
