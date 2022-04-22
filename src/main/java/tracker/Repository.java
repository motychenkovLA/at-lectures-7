package tracker;

public class Repository {
    private int MAX_COUNT;
    private static int currentDefectNum = 0;
    private static Defect[] defects;


    public Repository(int MAX_COUNT) {
        this.MAX_COUNT = MAX_COUNT;
        defects = new Defect[this.MAX_COUNT];
    }

    public static int getCurrentDefectNum() {
        return currentDefectNum;
    }

    public static void add(Defect defect){
        defects[currentDefectNum] = defect;
        currentDefectNum++;
    }

    public static Defect[] getAll() {
        return defects;
    }
}