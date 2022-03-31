package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите описание дефекта");
        String description = scanner.nextLine();

        System.out.println("Выберите кричтичность дефектов из:\n" +
                "-Blocker\n"  +
                "-Critical\n"  +
                "-Major\n"  +
                "-Minor\n"  +
                "-Trivial\n");
        String Severity = scanner.nextLine();

        System.out.println("Дни на исправление дефекта:");
        int number = scanner.nextInt();
        scanner.nextLine();

        System.out.println("На исправление дефекта " + description + " с критичностью " + Severity + " необходимо " + number + " дней ");
    }
}
