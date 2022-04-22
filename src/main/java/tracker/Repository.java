package tracker;

import java.util.Arrays;

public class Repository {
    private final int size;
    private Defect[] listDefect;
    private int capacity = 0;

    public Repository(int size) {
        this.size = size;
        listDefect = new Defect[size];
    }

    public boolean isFull() {
        return getCapacity() >= listDefect.length;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Defect defect) {
        listDefect[capacity] = defect;
        capacity++;
    }

    public Defect[] getAll() {
        return Arrays.copyOf(listDefect, capacity);
    }
}