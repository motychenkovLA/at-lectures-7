package tracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите резюме дефекта:");
        String resume = scanner.nextLine();
        System.out.println("Укажите критичность, \nHigh   Medium    Low:");
        String crit = scanner.nextLine();
        System.out.println("Введите, сколько дней потребуется для устранения:");
        int days = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Резюме: " + resume +  "\nКритичность: " + crit + "\nСрок устранения: " + days);
    }
}
