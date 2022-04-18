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
                        Defect defect = new Defect(1, null, null, null);
                        defects[currentDefectNum] = defect;
                        System.out.println("Введите резюме дефекта");
                        defect.setResume(scanner.nextLine());
                        System.out.println("Введите критичность дефекта (Blocker, Critical, Major, Minor, Trivial)");
                        defect.setSeverity(scanner.nextLine());
                        System.out.println("Введите ожидаемое количество дней на исправление дефекта");
                        defect.setDaysToFix(scanner.nextLine());
                        defect.setId(currentDefectNum+1);

                        currentDefectNum++;
                    }   else {
                        System.out.println("Нельзя ввести больше 10 дефектов!");
                    }
                    break;
                }

                case "list": {
                    System.out.println("Список дефектов:");
                    for (Defect defect : defects){
                        if (defect.defectID <= MAX_COUNT) {
                            System.out.println("ID: " + defect.getDefectID() + " | " +
                                    "Резюме: " + defect.getResume() + " | " + "Критичность: " + defect.getSeverity() +
                                    " | " + "Дни: " + defect.getDaysToFix());
                        }
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


