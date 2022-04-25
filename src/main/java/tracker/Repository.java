package tracker;

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

    public void getAll() {
        for (int i = 0; i < defects.length; i++) {
            System.out.println(defects[i].getId() + " | " + defects[i].getSummary() + " | " +
                    defects[i].getSeverity() + " | " + defects[i].getDays());
        }
    }
}
