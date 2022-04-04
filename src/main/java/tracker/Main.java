package tracker;

import java.util.Arrays;
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
                    System.out.println("Введите резюме дефекта");
                    resumes[currentDefectNum] = scanner.nextLine();
                    System.out.println("Введите критичность дефекта (Blocker, Critical, Major, Minor, Trivial)");
                    severity[currentDefectNum] = scanner.nextLine();
                    System.out.println("Введите ожидаемое количество дней на исправление дефекта");
                    daysToFix[currentDefectNum] = scanner.nextLine();

                    currentDefectNum++;
                    break;
                }

                case "list": {


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







//        int daysInWorkWeek = 5;
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Введите резюме дефекта");
//        String defectDescription = scanner.nextLine();
//        System.out.println("Введите критичность дефекта (Blocker, Critical, Major, Minor, Trivial)");
//        String defectSeverity = scanner.nextLine();
//        System.out.println("Введите ожидаемое количество дней на исправление дефекта");
//        int daysToFix = scanner.nextInt();
//        System.out.println("Описание дефекта: " + "\n" + defectDescription + "\n" + "Критичность дефекта:" + "\n" +
//                defectSeverity + "\n" + "Количество дней на исправление дефекта: " + daysToFix + "\n" +
//                "Займет больше рабочей недели: " + (daysToFix > daysInWorkWeek));

