package tracker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] array = new String[3];
        String[] array1 = new String[1];
        for (int i = 0; i < 3; i++) {

            System.out.println("Выберите действие: " + "\n" + "add - добавить новый дефект" + "\n" +
                    "list - вывести список" + "\n" + "quit - выйти из программы");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextLine()) {
                case "add":

                    for (i = 0; i < 1; i++) {
                        System.out.println("Введите резюме дефекта");
                        array1[i] = scanner.nextLine();
                        System.out.println("Введите критичность дефекта (Blocker, Critical, Major, Minor, Trivial)");
                        array1[i] = array1[i] + ", " + scanner.nextLine();
                        System.out.println("Введите ожидаемое количество дней на исправление дефекта");
                        array1[i] = array1[i] + ", " + scanner.nextLine();

                        array[i] = array1[i] + "\n";
                    }


                    break;


                case "list":
                    for ( i = 0; i < 3; i++) {
                        System.out.println(array[i]);
                    }

                    break;
                case "quit":
                    break;


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

