package tracker;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    static List<Defect> arrayDefect = new ArrayList<>();

    public static void addDef(Defect defect) {
        arrayDefect.add(defect);
    }
}
