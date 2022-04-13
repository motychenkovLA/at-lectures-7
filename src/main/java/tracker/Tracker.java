package tracker;


import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Tracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Введите операцию из списка:\nadd - добавить новый дефект\nlist - вывести список дефектов\nquit - выход");
            System.out.println();

            switch (sc.nextLine()) {
                case "add":
                    addDefect();
                    System.out.println();
                    break;
                case "list":
//                    System.out.println(Arrays.toString(ListDefect.arrayDefect));


//                    for (Defect def: ListDefect.arrayDefect)
//                        System.out.println(def);


//                  Применять к массиву, а не списку
//                    ListDefect.arrayDefect.stream().filter(Objects::nonNull).forEach(System.out::println);

                    for (int i = 0; i < ListDefect.arrayDefect.length; i++) {
                        if(ListDefect.arrayDefect[i].equals(null)) {
                            break;
                        }
                        System.out.println(ListDefect.arrayDefect[i]);
                        System.out.println("---------------------------");
                    }
                    System.out.println();
                    break;
                case "quit":
                    System.out.println("Выход из системы");
                    return;
                default:
                    System.out.println("Введена не существующая операция");
                    System.out.println();
            }
        }
    }

    public static void addDefect() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите резюме дефекта");
        String summary = scanner.nextLine();

        System.out.println("Введите критичность дефекта из списка:" + "\ntrivial, minor, major, critical, blocker");
        String criticality = scanner.nextLine();

        System.out.println("Введите количество дней на исправление");
        int countDay = scanner.nextInt();

        Defect defect = new Defect(summary, criticality, countDay);

        ListDefect.addDef(defect);
    }
}

