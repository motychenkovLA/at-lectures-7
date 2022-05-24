package tracker;

public class Repository {
    private final Defect[] listDefect;
    private int capacity = 0;

    public Repository(int size) {
        listDefect = new Defect[size];
    }

    public void add(Defect defect) {
        this.listDefect[capacity] = defect;
        capacity++;
    }

    public boolean isFull() {
        boolean full = capacity >= listDefect.length;
        return full;
    }

    public Defect[] getAll() {

        Defect[] copyListDefect = new Defect[capacity];
        for (int i = 0; i < capacity; i++) {
            copyListDefect[i] = listDefect[i];
        }
        return copyListDefect;
    }

    public Defect getById(long id) {
        for (int i = 0; i < capacity; i++) {
            Defect d = listDefect[i];
            if (d.getID() == id) {
                return d;
            }
        }
        return null;
    }
}