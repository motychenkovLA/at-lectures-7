package tracker;

import java.util.Arrays;

public class Repository {
    private final int size; // todo 1 - не используется, можно убрать
    private Defect[] listDefect; // todo 1 - можно зафиналить
    private int capacity = 0; // todo 1 - ну это size тогда, а не capacity; и наоборот

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