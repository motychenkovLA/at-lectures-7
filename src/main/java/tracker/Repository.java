package tracker;

public class Repository {

    private static Defect[] massivDefects = new Defect[10];
    private static int counter = 0;

    public static void add(Defect defect) {
        massivDefects[counter] = defect;
        counter++;

    }
    //private сделать если, то не могу обращаться к нему из Main
    public static Defect[] getAll() {
        return massivDefects;
    }

    public static int getCounter() {
        return counter;
    }
}

