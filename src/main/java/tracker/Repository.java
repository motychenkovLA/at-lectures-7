package tracker;

import java.util.Arrays;

public class Repository {

    private Defect[] list;
    private int counter = 0;

    public boolean isComplet() {
        if(counter >= list.length) {
            return true;
        }
        return false;
    }


    public Repository(int size) {
        list = new Defect[size];
    }

    public void addDefect(Defect defect) {

        list[counter] = defect;
        counter++;

    }

    public Defect[] getAll() {
        return list;
    }

    public int getCounterArray() {
        return counter;
    }

}
