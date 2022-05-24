package tracker;

import java.util.HashMap;
import java.util.Map;

public class Repository {

    private Map<Long, Defect> listDefect = new HashMap<>();

    public void add(Defect defect) {
        listDefect.put(defect.getId(), defect);
    }

    public Map<Long, Defect> getAll() {
        return listDefect;
    }

    public Defect getById(long id) {
        return listDefect.get(id);
    }
}
