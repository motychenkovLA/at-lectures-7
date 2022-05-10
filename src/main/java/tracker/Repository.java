package tracker;

public class Repository {

    public Defect[] list;
    public int counter = 0;

    public boolean isFull() {
        if (counter >= list.length) {
            return true;
        }
        return false;
    }

    public Repository(int size) {
        list = new Defect[size];
    }

    public void addDefect(Defect defect) {

        this.list[counter] = defect;
        counter++;

    }

    public Defect[] getAll() {
        return list;
    }


}
