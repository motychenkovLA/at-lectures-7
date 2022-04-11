package tracker;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        final int NUM_BUG = 3;
        String[] bugResume = new String[NUM_BUG];
        String[] bugCrit = new String[NUM_BUG];

        int[] bugDays = new int[NUM_BUG];
        int countReq = 0; // переменная для количества дефектов
        boolean isRun = true; // переменная для бесконечного цикла
        while (isRun) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выберите действие: \nAdd (Новый дефект)" +
                    " List (Вывести список дефектов)" +
                    " Quit (Вернуться в главное меню)");
            String action = scanner.nextLine();
            switch (action) {
                case ("Add"): {
                    if (countReq >= NUM_BUG) {
                        System.out.println("Невозможно добавить больше 3 дефектов");

                        break;
                    }
                    System.out.println("Введите резюме дефекта:");
                    bugResume[countReq] = scanner.nextLine();

                    System.out.println("Укажите критичность, \nHigh   Medium    Low:");
                    bugCrit[countReq] = scanner.nextLine();

                    System.out.println("Введите, сколько дней потребуется для устранения:");
                    bugDays[countReq] = scanner.nextInt();
                    scanner.nextLine();
                    countReq = countReq + 1;
                    break;
                }
                case "List":
                    for (int i = 0; i < countReq; i++) {
                        System.out.println("|" + i + "|" + bugResume[i] + "|" + bugCrit[i] + "|" + bugDays[i] + "|");
                    }
                    break;
                case "Quit":
                    isRun = false;
                    break;
                default:
                    System.out.println("Операции не существует");

            }
        }
    }
}


