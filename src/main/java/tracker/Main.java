package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int MAX_COUNT = 10;
        int currentDefectNum = 0;
        Defect[] defects = new Defect[MAX_COUNT];

        boolean isRun = true;
        while(isRun) {
            System.out.println("Выберите действие: " + "\n" + "add - добавить новый дефект" + "\n" +
                    "list - вывести список" + "\n" + "quit - выйти из программы");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextLine()) {
                case "add": {
                    if (currentDefectNum < MAX_COUNT) {
                        System.out.println("Введите резюме дефекта");
                        String resume = scanner.nextLine();
                        System.out.println("Введите критичность дефекта (Blocker, Critical, Major, Minor, Trivial)");
                        String severity = scanner.nextLine();
                        System.out.println("Введите ожидаемое количество дней на исправление дефекта");
                        String daysToFix = scanner.nextLine();
                        long id = currentDefectNum+1;

                        defects[currentDefectNum] = new Defect(id, resume, severity, daysToFix);

                        currentDefectNum++;
                    }   else {
                        System.out.println("Нельзя ввести больше 10 дефектов!");
                    }
                    break;
                }

                case "list": {
                    System.out.println("Список дефектов:");
                    for (int i = 0; i < currentDefectNum; i++) {
                        System.out.println("ID: " + defects[i].getID() + " | " + "Резюме: " +
                                defects[i].getResume() + " | " + "Критичность: " + defects[i].getSeverity() + " | " +
                                "Дни: " + defects[i].getDaysToFix());
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


