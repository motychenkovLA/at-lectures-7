package tracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        String priority;
        int days;

        System.out.println("Enter name:");
        name = scanner.nextLine();
        System.out.println("Enter priority: Trivial Minor Major Critical Blocker");
        priority = scanner.nextLine();
        System.out.println("Enter days: ");
        days = scanner.nextInt();

        System.out.println("Info about bug:\n" + "Name: " + name + "\nPriority: "
                + priority + "\nDays: " + days + "\nMore work week?: " + (days > 5));
        scanner.close();
    }
}
