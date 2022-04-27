package tracker;

public class Repository {
    private Defect[] defectRep;
    private int currentNumber = 0;

    public Repository(int maxCount) {
        this.defectRep = new Defect[maxCount];
    }

    public void addDefect(Defect defect) {
        if (currentNumber < defectRep.length) {
            defectRep[currentNumber] = defect;
            currentNumber++;
        }
    }

    public Defect[] getAll() {
        return defectRep;
    }

}
