package tracker;

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
                    for(Defect def: Repository.arrayDefect) {
                        System.out.println(def);
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
        String critic = "";
        while (true) {
            String criticality = scanner.nextLine();
            if (criticality.equals("trivial") || criticality.equals("minor") ||
                    criticality.equals("major") || criticality.equals("critical") ||
                    criticality.equals("blocker")) {
                critic = criticality;
                break;

            } else {
                System.out.println("Введены не корректые значения критичности\nПопробуйте еще раз");
            }
        }

        System.out.println("Введите количество дней на исправление");
        int countDay = scanner.nextInt();

        Defect defect = new Defect(summary, critic, countDay);

        Repository.addDef(defect);
    }
}

