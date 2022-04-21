package tracker;

public class Repository {

    private static int maxOfDefect;
    // todo 5+ - ТЗ: количество дефектов, которые могут храниться в Repository >>задается при создании его экземпляра<<
    private static Defect[] massivDefects = new Defect[maxOfDefect];
    Repository repository = new Repository(10);

    private static int counter = 0;

    public Repository(int maxOfDefect) {
        this.maxOfDefect = maxOfDefect;
    }

    public static void add(Defect defect) {
        massivDefects[counter] = defect;
        counter++;
    }

    public static void examination() {
        if (counter >= massivDefects.length) {
            System.out.println("Не возможно добавить дефект");
            System.out.println("___________________________");
            return;
        }
    }

    public static Defect[] getAll() {
        Defect[] newMassiv = new Defect[counter];
        for (int i = 0; i < massivDefects.length; i++) {
            if (massivDefects[i] != null) {
                newMassiv[i] = massivDefects[i];
            }
        }
        return newMassiv;
    }

    public static int getCounter() {
        return counter;
    }

}

