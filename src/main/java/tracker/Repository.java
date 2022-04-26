package tracker;

public class Repository {
    private final Defect[] listDefect;
    private int capacity = 0;

    public Repository(int size) {
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
        Defect[] array = new Defect[capacity];
        for (int a = 0; a < listDefect.length; a++) {
            if (listDefect[a] != null)
                array[a] = listDefect[a];
        }
        return array;
    }
}