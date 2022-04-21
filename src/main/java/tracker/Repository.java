package tracker;

public class Repository {

    // todo 5 - всегда будет 0 объектов в массиве, лекция 5 - подтема "порядок инициализации объекта"
    private static int maxOfDefect;
    // todo 5+ - ТЗ: количество дефектов, которые могут храниться в Repository >>задается при создании его экземпляра<<
    private static Defect[] massivDefects = new Defect[maxOfDefect];
    Repository repository = new Repository(10); // todo 3 - объект нигде не используется

    private static int counter = 0;

    public Repository(int maxOfDefect) {
        this.maxOfDefect = maxOfDefect; // todo 3 - обращение к статику на экземпляре, warning светит прямо в идее
    }

    public static void add(Defect defect) {
        massivDefects[counter] = defect;
        counter++;
    }

    public static void examination() {
        // todo 3
        //  - метод никак не влияет на поток выполнения в мейне, да и не может
        //  - репозиторий не должен работать с консолью
        if (counter >= massivDefects.length) {
            System.out.println("Не возможно добавить дефект");
            System.out.println("___________________________");
            return; // todo 3 - избыточный код
        }
    }

    public static Defect[] getAll() {
        Defect[] newMassiv = new Defect[counter];
        for (int i = 0; i < massivDefects.length; i++) { // todo 3 - создали размером counter, но перебираем до .length
            if (massivDefects[i] != null) { // todo 3 - если знаем наверняка сколько заполнено и перебираем только их, то проверка на null избыточна
                newMassiv[i] = massivDefects[i];
            }
        }
        return newMassiv;
    }

    public static int getCounter() {
        return counter;
    }

}

