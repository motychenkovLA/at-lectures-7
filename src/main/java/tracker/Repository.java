package tracker;


import java.util.Collection;
import java.util.HashMap;


public class Repository {

    private final HashMap<Long, Defect> listDefect = new HashMap<>();

    public void addDefect(Defect defect){
        listDefect.put(defect.getId(), defect);
    }

    public Collection<Defect> getAll(){
        return listDefect.values();
    }

    public Defect getById(long id){
        return listDefect.get(id);
    }
}


