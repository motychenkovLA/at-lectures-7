package tracker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        String choiceCommand;
        final int MAX_CAPACITY = 10;
        int currentDefectNumber = 0;

        Defect[] allDefects = new Defect[MAX_CAPACITY];

        while (true) {
            System.out.println("Select a command: \"add\", \"list\", \"quit\"");
            Scanner scanner = new Scanner(System.in);
            choiceCommand = scanner.nextLine();

            if (choiceCommand.equals("add")) {

                if (currentDefectNumber <= (MAX_CAPACITY - 1)) {

                    //если пользователь выбрал add, то создаЄм экземпл€р класса Defect

                    Defect bag = new Defect();
                    allDefects[currentDefectNumber] = bag;

                    bag.id = currentDefectNumber;

                    System.out.println("Enter a resume of the problem");
                    String description = scanner.nextLine();
                    bag.summary = description;

                    System.out.println("Please, enter a severity of the problem:\nS1 - Blocker;\nS2 - Critical;" +
                            "\nS3 - Major;\nS4 - Minor;\nS5 - Trivial");
                    String severity = scanner.nextLine();
                    bag.severity = severity;

                    System.out.println("How many days do you need to fix the problem?");
                    int numberOfDays = scanner.nextInt();
                    bag.days = numberOfDays;

                } else {
                    System.out.println("There is no place in array!");
                    continue;
                }

                currentDefectNumber++;

            } else if (choiceCommand.equals("list")) {

               for (int i = 0; i < currentDefectNumber; i++) {
                   System.out.println(allDefects[i].id + " | " + allDefects[i].summary + " | " +
                           allDefects[i].severity + " | " + allDefects[i].days);
               }

            } else if (choiceCommand.equals("quit")) {

                break;

            }
        }
    }
}

