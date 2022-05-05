package tracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Defect[] bugTable = new Defect[10];
        int defectNum = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:" +
                    "\n add - Завести дефект" +
                    "\n list - Показать список дефектов" +
                    "\n quit - Выход из программы");

            switch (scanner.nextLine()) {

                case "add":
                    if (defectNum >= 10) {
                        System.out.println("Уже заведено 10 дефектов");
                        break;
                    }
                    long Id = defectNum;

                    System.out.println("Введите резюме дефекта:");
                    String resume = scanner.nextLine();
                    System.out.println("Введите критичность дефекта (Высокая, Средняя, Низкая):");
                    String critical = scanner.nextLine();
                    System.out.println("Введите срок исправления дефекта, в днях:");
                    int dayToRepair = scanner.nextInt();
                    scanner.nextLine();
                    bugTable[defectNum] = new Defect(Id, critical, resume, dayToRepair);

                    defectNum++;
                    break;

                case "list":
                    for (int i = 0; i < defectNum; i++) {
                        System.out.println("№: " + bugTable[i].getId() +
                                " | " + "Резюме: " + bugTable[i].getResume() + " | " + "Критичность: "
                                + bugTable[i].getCritical() + " | "
                                + "Дни: " + bugTable[i].getDayToRepair());
                    }
                    break;

                case "quit":
                    System.out.println("Quit");
                    return;

                default:
                    System.out.println("Возврат в главное меню");
                    break;
            }
        }

    }

}