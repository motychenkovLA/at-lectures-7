package tracker;

import java.util.Scanner;

public class Main {

    public static final int MAX_COUNT = 10;

    public static void main(String[] args) {
        boolean exit = false;
        int count = 0;
        String name;
        String priority;
        int days;
        String[] array = new String[10];

        while (!exit) {
            System.out.println("Menu:" + "\n1-Add New Defect" + "\n2-Defect List " + "\n3-Quite");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextLine()) {
                case "1":
                    if (count < MAX_COUNT) {
                        System.out.println("Enter name:");
                        name = scanner.nextLine();
                        System.out.println("Enter priority: Trivial Minor Major Critical Blocker");
                        priority = scanner.nextLine();
                        System.out.println("Enter days: ");
                        days = scanner.nextInt();

                        array[count] = count + " . " + "Defect information:" + " Name: " + name + " Priority: "
                                + priority + " Days: " + days + " More work week?: " + (days > 5);

                        System.out.println("Defect information:\n" + "Name: " + name + "\nPriority: "
                                + priority + "\nDays: " + days + "\nMore work week?: " + (days > 5));
                        count++;
                    } else System.err.println("Is not possible to add more then 10 defects");
                    break;
                case "2":
                    System.out.println("Defect List: ");
                    for (int i = 0; i < count; i++) {
                        System.out.println(array[i]);
                    }
                    break;
                case "3":
                    exit = true;
                    break;
            }
        }
    }
}