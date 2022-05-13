package tracker;

import java.util.Scanner;

public class Main {
    private static String choise;
    private static final MainSteps mainStep = new MainSteps();

    public static void main(String[] args) {
        do {
            choise = mainStep.chooseAction();
            switch (choise) {
                case "add": {
                    mainStep.caseAdd();
                    break;
                }
                case "list": {
                    mainStep.caseList();
                    break;
                }
                case "change": {
                    mainStep.caseChange();
                    break;
                }
            }
        }
        while (!choise.equals("quit"));
    }


}
