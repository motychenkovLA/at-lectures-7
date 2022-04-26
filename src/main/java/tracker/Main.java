package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        String choiceCommand;
        final int MAX_CAPACITY = 1;

        Repository allDefects = new Repository(MAX_CAPACITY);

        boolean programRun = true;
        while (programRun) {
            System.out.println("Select a command: \"add\", \"list\", \"quit\"");
            Scanner scanner = new Scanner(System.in);
            choiceCommand = scanner.nextLine();

            switch (choiceCommand) {
                case "add":
                    if (!allDefects.isFull()) {

                        System.out.println("Enter a resume of the problem");
                        String description = scanner.nextLine();

                        System.out.println("Please, enter a severity of the problem:\nS1 - Blocker;\nS2 - Critical;" +
                                "\nS3 - Major;\nS4 - Minor;\nS5 - Trivial");
                        String severity = scanner.nextLine();

                        System.out.println("How many days do you need to fix the problem?");
                        int numberOfDays = scanner.nextInt();

                        allDefects.add(new Defect(description, severity, numberOfDays));

                    } else {
                        System.out.println("There is no place in array!\nChoose another command!");
                        continue;
                    }
                    break;
                case "list":

                    Defect[] all = allDefects.getAll();

                    for (int a = 0; a <= (all.length - 1); a++) {
                        System.out.println(all[a].getId() + " | " + all[a].getSummary() + " | " +
                        all[a].getSeverity() + " | " + all[a].getDays());
                    }

                    break;

                case "quit":
                    programRun = false;
                    System.out.println("Bye! See you soon!");
                    break;

                default:
                    System.out.println("Wrong command! Try again!");
                    break;
            }
        }
    }
}

