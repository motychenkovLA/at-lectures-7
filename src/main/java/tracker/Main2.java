package tracker;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        final int NUM_BUG = 10;
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
                    if (countReq > NUM_BUG - 1) {
                        System.out.println("Невозможно добавить больше 10 дефектов");

                        break;
                    }
                    System.out.println("Введите резюме дефекта:");
                    String resume = scanner.nextLine();

                    System.out.println("Укажите критичность, \nHigh   Medium    Low:");
                    String crit = scanner.nextLine();

                    System.out.println("Введите, сколько дней потребуется для устранения:");
                    int days = scanner.nextInt();
                    scanner.nextLine();
                    bugResume[countReq] = resume;
                    bugCrit[countReq] = crit;
                    bugDays[countReq] = days;
                    countReq = countReq + 1;
                    break;
                }
                case "List":
                    // System.out.println(Arrays.toString(listbug));
                    for (int i = 0; i < countReq; i++) {
                        System.out.println("|" + i + "|" + bugResume[i] + "|" + bugCrit[i] + "|" + bugDays[i] + "|");
                    }
                    break;
                case "Quit":
                    isRun = false;
                    break;
                default:
                    System.out.println("Операции не существует");
                    break;
            }
        }
    }
}


