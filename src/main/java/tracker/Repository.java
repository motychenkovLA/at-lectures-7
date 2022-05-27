package tracker;

import java.util.*;

public class Repository {

    private final Map<Long, Defect> listDefect = new HashMap<>();

    public void add(Defect defect) {
        listDefect.put(defect.getId(), defect);
    }

    public Collection<Defect> getAll() {
        return listDefect.values();
    }

    public Defect getById(long id) {
        return listDefect.get(id);
    }

    public List<Integer> getCountAmountOfDay() {
        List<Integer> bug = new ArrayList<>();
        for (Map.Entry<Long, Defect> entry : listDefect.entrySet()) {
            bug.add(entry.getValue().getAmountOfDays());
        }
        return bug;
    }
}
