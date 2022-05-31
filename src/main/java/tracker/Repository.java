package tracker;

import java.util.Arrays;

public class Repository {

    public Defect[] list;
    public int counter = 0;

    public boolean isFull() {
        if (counter >= list.length) {
            return true;
        }
        return false;
    }

    public int getCounter() {
        return counter;
    }

    public Repository(int size) {
        list = new Defect[size];
    }

    public void addDefect(Defect defect) {

        this.list[counter] = defect;
        counter++;

    }

    public Defect[] getAll() {
        Defect[] copyListDefect = Arrays.copyOf(list, counter);
        return copyListDefect;
    }

}
