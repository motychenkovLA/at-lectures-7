package tracker;

import java.util.Scanner;

public class Main {
    static long counter = 1;
    static final int MAX_DEFECT_COUNT = 1;
    static Defect[] defects = new Defect[MAX_DEFECT_COUNT];

    public static Defect addDefect() {
        long index = counter - 1;
        Defect defect = new Defect(counter++);
        defects[(int) index] = defect;
        return defect;
    }

    public static void main(String[] args) {

        /* Главное меню */
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите операцию из списка:\nadd - добавить новый дефект; " +
                    "\nlist - вывести список дефектов; \nquit - выход");
            String operation = scanner.nextLine();

            switch (operation) {
                case "add":
                    if (counter > MAX_DEFECT_COUNT) {
                        System.out.println("Не возможно добавить дефект");
                        break;
                    }
                    processDefect(scanner);

                    scanner.nextLine();
                    break;

                case "list":
                    printDefects();
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

    private static void processDefect(Scanner scanner) {
        Defect defect = addDefect();/*создали пустой дефект и вернули, есть только id*/
        System.out.println("Введите описание дефекта");
        String description = scanner.nextLine();
        defect.setDescription(description);

        System.out.println("Выберите кричтичность дефектов из:\n" +
                "-Blocker\n" +
                "-Critical\n" +
                "-Major\n" +
                "-Minor\n" +
                "-Trivial\n");
        String severity = scanner.nextLine();
        defect.setSeverity(severity);

        System.out.println("Дни на исправление дефекта:");
        int amountOfDays = scanner.nextInt();
        defect.setAmountOfDays(amountOfDays);
    }

    private static void printDefects() {
        for (Defect defect : defects) {
            if (defect != null) {
                System.out.println("id дефекта:\t" + defect.getIdDefect() + "|" + " описание дефекта:\t" +
                        defect.getDescription() + "|" + " критичность дефекта:\t" + defect.getSeverity() + "|"
                        + " количество дней на исправлени:\t" + defect.getAmountOfDays());
                System.out.println();
            }
        }
    }
}

