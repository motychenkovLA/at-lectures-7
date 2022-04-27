package tracker;

public class Repository {

    private final Defect[] defects;
    private final int count;
    public static int numberDefects = 0;

    public Repository(int count) {
        this.count = count;
        this.defects = new Defect[count];
    }

    void add(Defect defect){
        if(numberDefects <= count) {
            defects[numberDefects] = defect;
            numberDefects++;
        }
    }

    Defect[] getAll(){
       return defects;
    }
}
