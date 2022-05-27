package tracker;

import java.util.HashMap;
import java.util.Map;

public class Repository {
    private Map<Long, Defect> defectRep = new HashMap<>();


    public void addDefect(Defect defect) {
        defectRep.put(defect.getId(), defect);
    }

    public Map<Long, Defect> getAll() {
        return defectRep;
    }


    public boolean defectIsFound(long id) throws MyExeption {

        if (this.defectRep.containsKey(id)) return true;
        else throw new MyExeption();

    }

}
