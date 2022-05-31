package tracker;

import java.util.*;
import java.util.stream.Stream;

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

    public void getStatistic() {

        IntSummaryStatistics statistics = defectRep.values().stream().mapToInt(d -> d.getDay()).summaryStatistics();
        System.out.println("Маскимальное время исправления - " + statistics.getMax()
                + ", среднее время исправления - " + statistics.getAverage()
                + ", минимальное время исправления - " + statistics.getMin());
        System.out.println(Status.OPEN.name + " - " + defectRep.values().stream().filter(x -> x.getStatus().ordinal() == Status.OPEN.ordinal()).count());
        System.out.println(Status.IN_PROGRESS.name + " - " + defectRep.values().stream().filter(x -> x.getStatus().ordinal() == Status.IN_PROGRESS.ordinal()).count());
        System.out.println(Status.IN_TESTING.name + " - " + defectRep.values().stream().filter(x -> x.getStatus().ordinal() == Status.IN_TESTING.ordinal()).count());
        System.out.println(Status.CLOSED.name + " - " + defectRep.values().stream().filter(x -> x.getStatus().ordinal() == Status.CLOSED.ordinal()).count());

    }
}
