package tracker;

import java.util.Arrays;

public class Repository {
    private int size; // todo 1 - можно зафиналить
    private static Defect[] listDefect; // todo 5 - общий массив на все репо
    private static int counterDefectSize = 0;

    public Repository(int size) {
        this.size = size;
        listDefect = new Defect[size];
    }

    // todo 1 - не говорящее название, существительное но почему-то метод. isFull как вариант
    public static boolean maxSize() {
        return getCounterDefectSize() >= listDefect.length;
    }

    // todo 1 - какое-то огромное название,
    //  вообще по канону максимальный размер - это capacity, а текущий - size,
    //  но тут можно хотя бы просто count оставить
    public static int getCounterDefectSize() {
        return counterDefectSize;
    }

    public static void add(Defect defect) {
        listDefect[counterDefectSize] = defect;
        counterDefectSize++;
    }

    public static Defect[] getAll() {
        return Arrays.copyOf(listDefect, counterDefectSize);
    }
}