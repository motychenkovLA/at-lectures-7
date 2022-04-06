package tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        String choiceCommand;
        final int MAX_CAPACITY = 10;
        int currentDefectNumber = 0;

        int [] id = new int[MAX_CAPACITY];
        String[] descriptionArray = new String[MAX_CAPACITY];
        String[] severityArray = new String[MAX_CAPACITY];
        String [] summaryArray = new String[MAX_CAPACITY];

        while (true) {
            System.out.println("Select a command: \"add\", \"list\", \"quit\"");
            Scanner scanner = new Scanner(System.in);
            choiceCommand = scanner.nextLine();

            if (choiceCommand.equals("add")) {
                if (currentDefectNumber != 10 ) {
                    id[currentDefectNumber] = currentDefectNumber;

                    System.out.println("Enter a resume of the problem");
                    String description = scanner.nextLine();
                    descriptionArray[currentDefectNumber] = "Resume: " + description;

                    System.out.println("Please, enter a severity of the problem:\nS1 - Blocker;\nS2 - Critical;" +
                            "\nS3 - Major;\nS4 - Minor;\nS5 - Trivial");
                    String severity = scanner.nextLine();
                    severityArray[currentDefectNumber] = "Severity: " + severity;

                    System.out.println("How many days do you need to fix the problem?");
                    int numberOfDays = scanner.nextInt();
                    summaryArray[currentDefectNumber] = "Days for fix: " + numberOfDays;

                } else {
                    System.out.println("There is no place in array!");
                    continue;
                }

                currentDefectNumber++;

            } if (choiceCommand.equals("list")) {

               for (int i = 0; i < currentDefectNumber; i++) {
                   System.out.println(id[i] + " | " + descriptionArray[i] + " | " + severityArray[i] +
                          " | " + summaryArray[i] );
               }

            } if (choiceCommand.equals("quit")) {

                break;

            }
        }
    }
}

