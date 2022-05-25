package tracker;

import java.util.HashMap;
import java.util.Map;

public class Repository {
    private final int MAX_COUNT = 10;
    private int currentDefectNum = 1;
    private final Map<Long, Defect> defects = new HashMap<>();


    public int getCurrentDefectNum() {
        return currentDefectNum;
    }

    public void add(Defect defect){
        defects.put(defect.getID(), defect);
        currentDefectNum++;
    }

    public Map<Long, Defect> getAll(){
        return defects;
    }

    public boolean isFull(){
        return currentDefectNum <= MAX_COUNT;
    }
}