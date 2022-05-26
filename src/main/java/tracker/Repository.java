package tracker;

import java.util.*;

public class Repository {

    private Map<Long, Defect> listDefect = new TreeMap<>();

    public void addDef(Defect defect) {
        listDefect.put(defect.getID(), defect);
    }

    public List<Integer> getCounterDay() {
        List<Integer> deff = new ArrayList<>();
        for(Map.Entry<Long, Defect> entry :listDefect.entrySet()) {
            deff.add(entry.getValue().getCountDay());
        }
        return deff;
    }

    public List<Defect> getAllDefect() {
        List<Defect> def = new ArrayList<>();
        for(Map.Entry<Long, Defect> entry :listDefect.entrySet()) {
           def.add(entry.getValue());
        }
        return def;
    }

    public Defect getById(long id) {
            return listDefect.get(id);
    }
}
