package tracker;

import java.util.Arrays;

public class Repository {

    private final int max_capacity;
    private final Defect[] defects;
    private int defectNumber = 0;

    public Repository(int max_capacity) {
        this.max_capacity = max_capacity;
        defects = new Defect[max_capacity];
    }

    void add(Defect defect) {
        defects[defectNumber] = defect;
        defectNumber++;
    }

    public Defect[] getAll() {
        return Arrays.copyOfRange(this.defects, 0, defectNumber);
    }

    public boolean isFull() {
        return defectNumber >= max_capacity;
    }
}
