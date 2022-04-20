package tracker;

public class Repository {

    // todo 5+ - ТЗ: количество дефектов, которые могут храниться в Repository >>задается при создании его экземпляра<<
    private static Defect[] massivDefects = new Defect[10];
    private static int counter = 0;

    public static void add(Defect defect) {
        massivDefects[counter] = defect;
        counter++;

    }
    //private сделать если, то не могу обращаться к нему из Main
    // todo 3+ - утечка массива наружу, внешний пользователь получает доступ к внутреннему объекту репозитория,
    //  в результате не гарантируется его валидность
    //  + >>возвращается массив с null-ами а не только дефектами<<
    public static Defect[] getAll() {
        return massivDefects;
    }

    public static int getCounter() {
        return counter;
    }
}

