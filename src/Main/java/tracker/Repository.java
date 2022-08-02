package tracker;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class Repository {

    private final Map<Long, Defect> listDefect = new TreeMap<>();

    public void add(Defect defect) {
        listDefect.put(defect.getID(), defect);
    }

    public Collection<Defect> getAll() {
        return listDefect.values();
    }

    public Defect getById(long id) {
        return listDefect.get(id);
    }

}