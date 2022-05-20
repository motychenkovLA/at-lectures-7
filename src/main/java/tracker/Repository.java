package tracker;

public class Repository {

    private final Defect[] massivDefects;
    private int counter = 1; // todo 5 - дефекты записываются с 1 индекса, в 0 всегда лежит null

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

    public Defect getById(long id) {
        for (int i = 0; i < counter; i++) {
            Defect d = massivDefects[i];
            if (d == null) { // todo 1 - раз перебираем до counter можно не проверять на null, дефект наверняка есть
                continue;
            }
            if (d.getId() == id) {
                return d;
            }
        }
        return null;
    }
}

