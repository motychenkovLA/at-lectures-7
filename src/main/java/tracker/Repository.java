package tracker;

public class Repository {
    private final int MAX_COUNT;
    private int currentDefectNum = 0;
    private final Defect[] defects;


    public Repository(int maxCount) {
        this.MAX_COUNT = maxCount;
        defects = new Defect[this.MAX_COUNT];
    }

    public int getCurrentDefectNum() {
        return currentDefectNum;
    }

    public void add(Defect defect){
        defects[currentDefectNum] = defect;
        currentDefectNum++;
    }

    public Defect[] getAll() {
        return defects;
    }

    public boolean isFull(){
        return currentDefectNum <= MAX_COUNT;
    }
}