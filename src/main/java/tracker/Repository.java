package tracker;

import java.util.Arrays;

public class Repository {
    private Defect[] listDefect;
    private int capacity = 0;

    public Repository(int size) {
        listDefect = new Defect[size];
    }

    public boolean isFull() {
        // todo 3 - if (true) { return true; } else { return false; } зачем? почему сразу не вернуть?
        if(capacity >= listDefect.length) {
            return true;
        }
        return false;
    }

    public void add(Defect defect) {
        listDefect[capacity] = defect;
        capacity++;
    }

    public int getCapacity() {
        return capacity;
    }

    public Defect[] getAll() {
        Defect[] copyListDefect = Arrays.copyOf(listDefect, capacity);
        return copyListDefect;
    }
}