package tracker;

public class Repository {
    static final int LENGTH_ARRAY = 10;
    static Defect[] listDefect = new Defect[LENGTH_ARRAY];
    static int counterArray = 0;

    public static void addDef(Defect defect) {
        listDefect[counterArray] = defect;
        counterArray++;
    }

    public static Defect[] getAll() {
        for(int i = 0; i < Repository.counterArray; i++) {
            System.out.println(listDefect[i].info());
            System.out.println("---------------------------");
        }
        return listDefect;
    }
}
