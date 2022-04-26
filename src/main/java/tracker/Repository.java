package tracker;

public class Repository {
    private final int maxCount;
    private Defect[] defectRep;
    private int currentNumber = 0;

    public Repository(int maxCount) {
        this.maxCount = maxCount;
        this.defectRep = new Defect[maxCount];
    }

    public void addDefect(Defect defect) {
        if (currentNumber < maxCount) {
            defectRep[currentNumber] = defect;
            currentNumber++;
        }
    }

    public void getAll() {
        if (currentNumber != 0) {
            for (Defect d1 : defectRep) {
                if (d1 != null) {
                    System.out.println(d1.getId() + " | " + d1.getSummary() + " | " + d1.getSeverity() + " | " + d1.getDay());
                }
            }
        }
    }

}
