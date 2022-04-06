package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        String choiceCommand;
        final int MAX_CAPACITY = 10;
        int currentDefectNumber = 0;

        int [] id = new int[MAX_CAPACITY];
        String[] allSummary= new String[MAX_CAPACITY];
        String[] allSeverity = new String[MAX_CAPACITY];
        int [] allDeadline = new int[MAX_CAPACITY];

        while (true) {
            System.out.println("Select a command: \"add\", \"list\", \"quit\"");
            Scanner scanner = new Scanner(System.in);
            choiceCommand = scanner.nextLine();

            if (choiceCommand.equals("add")) {

                if (currentDefectNumber <= (MAX_CAPACITY - 1)) {

                    id[currentDefectNumber] = currentDefectNumber;

                    System.out.println("Enter a resume of the problem");
                    String description = scanner.nextLine();
                    allSummary[currentDefectNumber] = description;

                    System.out.println("Please, enter a severity of the problem:\nS1 - Blocker;\nS2 - Critical;" +
                            "\nS3 - Major;\nS4 - Minor;\nS5 - Trivial");
                    String severity = scanner.nextLine();
                    allSeverity[currentDefectNumber] = severity;

                    System.out.println("How many days do you need to fix the problem?");
                    int numberOfDays = scanner.nextInt();
                    allDeadline[currentDefectNumber] = numberOfDays;

                } else {
                    System.out.println("There is no place in array!");
                    continue;
                }

                currentDefectNumber++;

            } if (choiceCommand.equals("list")) {

               for (int i = 0; i < currentDefectNumber; i++) {
                   System.out.println(id[i] + " | " + "Resume: " + allSummary[i] + " | " + "Severity: " + allSeverity[i] +
                          " | " + "Days for fix: " + allDeadline[i] );
               }

            } if (choiceCommand.equals("quit")) {

                break;

            }
        }
    }
}

