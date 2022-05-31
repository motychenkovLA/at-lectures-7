package tracker;

import java.util.Scanner;

public class Main {

    private static String choise;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                choise = MainSteps.chooseAction(scanner);
                switch (choise) {
                    case "add": {
                        MainSteps.caseAdd(scanner);
                        break;
                    }
                    case "list": {
                        MainSteps.caseList();
                        break;
                    }
                    case "change": {
                        MainSteps.caseChange(scanner);
                        break;
                    }
                    case "stats": {
                        MainSteps.caseStats();
                        break;
                    }
                    case "quit":
                        break;
                    default:
                        System.out.println("неизвестный выбор");
                }
            }
            while (!choise.equals("quit"));
        }
    }

}
