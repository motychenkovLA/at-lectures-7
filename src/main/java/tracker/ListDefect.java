package tracker;

public class ListDefect {
    private static int countDefect = 0;
    static Defect[] arrayDefect = new Defect[10];

    public static void addDef (Defect defect) {
        if (countDefect > arrayDefect.length - 1) {
            System.out.println("Размер массива вышел за пределы");
            return;
        }
        arrayDefect[countDefect] = defect;
        countDefect++;
    }


}
