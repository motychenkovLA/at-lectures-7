package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please, enter a description of the problem");
        Scanner scanner = new Scanner(System.in);
        String description = scanner.nextLine();
        System.out.println("Please, enter a severity of the problem:\nS1 - Blocker;\nS2 - Critical;\nS3 - Major;\nS4 - Minor;\nS5 - Trivial");
        String severity = scanner.nextLine();
        System.out.println("How many days do you need to fix the problem?");
        int numberOfDays =scanner.nextInt();
        System.out.println("Description: " + description + "\nSeverity: " + severity + "\nWorkload in days: " + numberOfDays);
    }
}
