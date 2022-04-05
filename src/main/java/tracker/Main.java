package tracker;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final int MAX_COUNT = 10;
        int currentDefectNum = 0;

        String[] resumes = new String[MAX_COUNT];
        String[] severity = new String[MAX_COUNT];
        String[] daysToFix = new String[MAX_COUNT];

        boolean isRun = true;
        while(isRun) {

            System.out.println("Выберите действие: " + "\n" + "add - добавить новый дефект" + "\n" +
                    "list - вывести список" + "\n" + "quit - выйти из программы");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextLine()) {
                case "add": {
                    if (currentDefectNum < MAX_COUNT) {
                        System.out.println("Введите резюме дефекта");
                        resumes[currentDefectNum] = scanner.nextLine();
                        System.out.println("Введите критичность дефекта (Blocker, Critical, Major, Minor, Trivial)");
                        severity[currentDefectNum] = scanner.nextLine();
                        System.out.println("Введите ожидаемое количество дней на исправление дефекта");
                        daysToFix[currentDefectNum] = scanner.nextLine();

                        currentDefectNum++;
                    }
                    else {
                        System.out.println("Нельзя ввести больше 10 дефектов!");
                    }
                    break;
                }

                case "list": {
                    for (int i = 0; i < currentDefectNum; i++){
                        System.out.println(i + " | " + resumes[i] + " | " +
                                severity[i] + " | " + daysToFix[i]);
                    }
                    break;
                }

                case "quit": {
                    isRun = false;
                    break;
                }
            }
        }
    }
}


