package tracker;

import java.util.*;

public class Repository {

    private Map<Long, Defect> map = new HashMap<>();

    public void addDefect(Defect defect) {
        map.put(defect.getID(), defect);
    }

    public Defect getById(long id) {
        return map.get(id);
    }

    public List<Defect> getAllDefect() {
        List<Defect> def = new ArrayList<>();
        for(Map.Entry<Long, Defect> entry :map.entrySet()) {
            def.add(entry.getValue());
        }
        return def;
    }
}
