package tracker;

public class Repository {

    private final Defect[] massivDefects;
    private int counter = 1;

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

    // todo 5 - возвращает не по id а по индексу в массиве,
    //   индекс в массиве вообще не обязательно совпадает с id, никаких гарантий нету
    public Defect getById(int id) {
        return massivDefects[id];
    }
}

