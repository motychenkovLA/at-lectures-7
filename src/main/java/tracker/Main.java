package tracker;

import java.util.Scanner;

public class Main {
    private static final int WEEK = 5;
    public static void main(String[] args) {
        Scanner bugReport = new Scanner(System.in);
        String name;
        String priority;
        int days = 0;
        boolean daysOfWeek = false;

        System.out.println("Enter name:");
        name = bugReport.nextLine();
        System.out.println("Enter priority: Trivial Minor Major Critical Blocker");
        priority = bugReport.nextLine();

        if ((priority.equals("Trivial")) || (priority.equals("Minor"))
                || (priority.equals("Major")) || (priority.equals("Critical")) || (priority.equals("Blocker"))) {
            System.out.println("Enter days: ");
            days = bugReport.nextInt();
            if (days > WEEK) {
                daysOfWeek = true;
            }
        } else {
            System.err.println("Error type");
        }

        System.out.println("Name: "+name+" Priority: "+priority+" Days: "+days+" More work week?: "+daysOfWeek);
        bugReport.close();
    }
}
