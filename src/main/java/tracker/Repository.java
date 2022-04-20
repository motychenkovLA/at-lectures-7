package tracker;

public class Repository {

    private static final int MAX_DEFECT_COUNT = 10;
    private static Defect[] massivDefects = new Defect[MAX_DEFECT_COUNT];
    private static int counter = 0;

    public static void add(Defect defect) {
        massivDefects[counter] = defect;
        counter++;
    }

    public static Defect[] getAll() {
    return massivDefects;
    }

    public static int getCounter(){
        return counter;
    }

    public static Defect[] getMassivDefects(){
        return massivDefects;
    }
}
