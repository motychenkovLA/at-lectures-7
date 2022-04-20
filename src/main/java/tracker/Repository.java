package tracker;

public class Repository {

    private static final int MAX_DEFECT_COUNT = 10;
    // todo 5 - ТЗ: количество дефектов, которые могут храниться в Repository задается при создании его экземпляра
    private static Defect[] massivDefects = new Defect[MAX_DEFECT_COUNT];
    private static int counter = 0;

    public static void add(Defect defect) {
        massivDefects[counter] = defect;
        counter++;
    }

    // todo 3 - утечка массива наружу, внешний пользователь получает доступ к внутреннему объекту репозитория,
    //  в результате не гарантируется его валидность
    //  + возвращается массив с null-ами а не только дефектами
    public static Defect[] getAll() {
    return massivDefects; // todo 0 - отступ
    }

    public static int getCounter(){
        return counter;
    }

    public static Defect[] getMassivDefects(){ // todo 3 - дубликат кода getAll
        return massivDefects;
    }
}
