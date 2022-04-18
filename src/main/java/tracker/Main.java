package tracker;

import java.util.Scanner;

public class Main {

    static final int MAX_DEFECT_COUNT = 10;
    static Defect[] massivDefects = new Defect[MAX_DEFECT_COUNT];
    static int counter = 0;

    public static void addDefect(Defect defect) {
        massivDefects[counter] = defect;
        counter++;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите операцию из списка:\nadd - добавить новый дефект; " +
                    "\nlist - вывести список дефектов; \nquit - выход");
            String operation = scanner.nextLine();

            switch (operation) {
                case "add":
                    if (counter >= massivDefects.length) {
                        System.out.println("Не возможно добавить дефект");
                        break;
                    }
                    processDefect(scanner);
                    break;

                case "list":
                    for (int i = 0; i < counter; i++) {
                        System.out.println(massivDefects[i]);
                    }
                    break;

                case "quit":
                    System.out.println("Выход из системы");
                    return;

                default:
                    System.out.println("Такой операции не существует\n");
                    break;
            }
        }
    }

    public static void processDefect(Scanner scanner) {
        System.out.println("Введите описание дефекта");
        String description = scanner.nextLine();

        System.out.println("Выберите кричтичность дефектов из:\n" +
                "-Blocker\n" +
                "-Critical\n" +
                "-Major\n" +
                "-Minor\n" +
                "-Trivial\n");
        String severity = scanner.nextLine();

        System.out.println("Дни на исправление дефекта:");
        int amountOfDays = scanner.nextInt();
        scanner.nextLine();

        Defect defect = new Defect(description, severity, amountOfDays);
        addDefect(defect);

    }
}

