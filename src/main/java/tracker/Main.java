package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите описание дефекта");
        String description = scanner.nextLine();

        System.out.println("Выберите кричтичность дефектов из:\n" +
                "-Blocker\n" +
                "-Critical\n" +
                "-Major\n" +
                "-Minor\n" +
                "-Trivial\n");
        // todo 1 - форматирование названия переменной
        String Severity = scanner.nextLine();

        System.out.println("Дни на исправление дефекта:");
        int number = scanner.nextInt();
        scanner.nextLine();

        System.out.println("На исправление дефекта " + description + " с критичностью " + Severity + " необходимо " + number + " дней ");

        // todo 3 - 5 лучше вынести в именованную константу
        boolean week = number > 5;

        System.out.println("Это займет больше недели?:" + week);
    }
}

