package tracker;

import java.util.HashMap;
import java.util.Map;

public class Repository {

    private final Map<Long, Defect> listDefect = new HashMap<>();

    public void add(Defect defect) {
        listDefect.put(defect.getId(), defect);
    }

    // todo 3 - зачем целую мапу то возвращать, если только дефекты просят? + утечка внутреннего состояния  - спросила у Лени
    public Map<Long, Defect> getAll() {
        return listDefect;
    }

    public Defect getById(long id) {
        return listDefect.get(id);
    }
}
