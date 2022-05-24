package tracker;

import java.util.Map;
import java.util.TreeMap;

public class Repository {

    private final Map<Long, Defect> listDefect = new TreeMap<>();

    public void add(Defect defect) {
        listDefect.put(defect.getID(), defect);
    }

    public Map<Long, Defect> getAll() {
        return listDefect;
    }

    public Defect getById(long id) {
        return listDefect.get(id);
    }

}