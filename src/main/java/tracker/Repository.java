package tracker;

import java.util.Map;
import java.util.TreeMap;

public class Repository {

    private Map<Long, Defect> listDefect = new TreeMap<>();

    public void addDef(Defect defect) {
        listDefect.put(defect.getID(), defect);
    }

    public Map<Long, Defect> getAll() {
        return listDefect;
    }



}
