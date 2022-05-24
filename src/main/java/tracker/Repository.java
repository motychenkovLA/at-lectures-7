package tracker;

import java.util.HashMap;
import java.util.Map;

public class Repository {

    private Map<Long, Defect> listDefect = new HashMap<>(); // todo 3 - final

    public void add(Defect defect) {
        listDefect.put(defect.getId(), defect);
    }

    // todo 3 - зачем целую мапу то возвращать, если только дефекты просят? + утечка внутреннего состояния
    public Map<Long, Defect> getAll() {
        return listDefect;
    }

    public Defect getById(long id) {
        return listDefect.get(id);
    }
}
