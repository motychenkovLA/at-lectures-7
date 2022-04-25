package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        String choiceCommand;
        final int MAX_CAPACITY = 2;
        int currentDefectNumber = 0;

        Repository allDefects = new Repository(MAX_CAPACITY);

        while (true) {
            System.out.println("Select a command: \"add\", \"list\", \"quit\"");
            Scanner scanner = new Scanner(System.in);
            choiceCommand = scanner.nextLine();

            if (choiceCommand.equals("add")) {

                if (currentDefectNumber <= (MAX_CAPACITY - 1)) {

                    System.out.println("Enter a resume of the problem");
                    String description = scanner.nextLine();

                    System.out.println("Please, enter a severity of the problem:\nS1 - Blocker;\nS2 - Critical;" +
                            "\nS3 - Major;\nS4 - Minor;\nS5 - Trivial");
                    String severity = scanner.nextLine();

                    System.out.println("How many days do you need to fix the problem?");
                    int numberOfDays = scanner.nextInt();

                    allDefects.add(new Defect(description, severity, numberOfDays));

                } else {
                    System.out.println("There is no place in array!");
                    continue;
                }

                currentDefectNumber++;

            } else if (choiceCommand.equals("list")) {

                allDefects.getAll();

            } else if (choiceCommand.equals("quit")) {

                break;

            }
        }
    }
}

