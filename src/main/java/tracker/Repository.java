package tracker;

public class Repository {
    private final Defect[] listDefect;
    private int capacity = 0;

    public int getCapacity() {
        return capacity;
    }

    public Repository(int size) {
        listDefect = new Defect[size];
    }

    public void add(Defect defect) {
        this.listDefect[capacity] = defect;
        capacity++;
    }

    public boolean isFull() {
        boolean full;
        full = capacity >= listDefect.length;
        return full;
    }

    public Defect[] getAll() {
        Defect[] array = new Defect[capacity];
        for (int x = 0; x < capacity; x++) {
            if (listDefect[x] != null)
                array[x] = listDefect[x];
        }
        return array;
    }
}