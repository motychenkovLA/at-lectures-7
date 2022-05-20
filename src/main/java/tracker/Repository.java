package tracker;

import java.util.HashMap;

public class Repository {

    private HashMap <Long, Defect> listDefect = new HashMap<>();

    public void addDef(Defect defect) {
        listDefect.put(defect.getID(), defect);
    }

    public HashMap<Long, Defect> getAll() {
        return listDefect;
    }



}
