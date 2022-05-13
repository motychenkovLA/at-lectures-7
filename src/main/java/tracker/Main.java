package tracker;

import java.util.Scanner;

public class Main {
    private static String choise;

    public static void main(String[] args) {
        do {
            choise = MainSteps.chooseAction();
            switch (choise) {
                case "add": {
                    MainSteps.caseAdd();
                    break;
                }
                case "list": {
                    MainSteps.caseList();
                    break;
                }
                case "change": {
                    MainSteps.caseChange();
                    break;
                }
            }
        }
        while (!choise.equals("quit"));
    }


}
