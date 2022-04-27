package tracker;

public class Repository {

    private final Defect[] massivDefects; // todo 1 - можно зафиналить- исправлено
    private int counter = 0;

    public Repository(int maxOfDefect) {
        massivDefects = new Defect[maxOfDefect];
    }

    public void add(Defect defect) {
        this.massivDefects[counter] = defect;
        counter++;
    }

    public boolean isFull() {
        boolean full = counter >= massivDefects.length;
        return full;
    }

    public Defect[] getAll() {
        Defect[] newMassiv = new Defect[counter];
        for (int i = 0; i < counter; i++) {
            newMassiv[i] = massivDefects[i];
        }
        return newMassiv;
    }
}

