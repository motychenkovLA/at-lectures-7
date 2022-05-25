package tracker;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Repository {

    private final Map<Long, Defect> listDefect = new HashMap<>();

    public void add(Defect defect) {
        listDefect.put(defect.getId(), defect);
    }

    // todo 3 - все еще не коллекция дефектов
    public Set<Map.Entry<Long, Defect>> getAll() {
        return listDefect.entrySet();
    }

    public Defect getById(long id) {
        return listDefect.get(id);
    }
}
