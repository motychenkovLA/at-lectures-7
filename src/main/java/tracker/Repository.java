package tracker;

public class Repository {
    // todo 5 - ТЗ: количество дефектов, которые могут храниться в Repository задается при создании его экземпляра
    private static final int MAX_DEFECT_SIZE = 10;
    private static Defect[] listDefect = new Defect[MAX_DEFECT_SIZE];
    private static int counterDefectSize = 0;

    // todo 3
    //  - возвращает массив в котором кроме дефектов содержатся null-ы
    //  - происходит утечка внутреннего массива, после этого репо не может гарантировать его валидность
    public static Defect[] getListDefect() {
        return listDefect;
    }

    public static int getCounterDefectSize() {
        return counterDefectSize;
    }

    public static void add(Defect defect) {
        listDefect[counterDefectSize] = defect;
        counterDefectSize++;
    }

    // todo 3 - дубликат метода getListDefect
    //    второе дз в котором я вижу этот дубликат, если вы вместе делаете, то хоть проверяйте друг друга
    public static Defect[] getAll() {
        return listDefect;
    }

}
