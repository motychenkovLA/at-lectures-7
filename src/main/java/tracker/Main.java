package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int MAX_COUNT = 10;
        Repository repository = new Repository(MAX_COUNT);

        boolean isRun = true;
        while(isRun) {
            System.out.println("Выберите действие: " + "\n" + "add - добавить новый дефект" + "\n" +
                    "list - вывести список" + "\n" + "quit - выйти из программы");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextLine()) {
                case "add": {
                    if (Repository.getCurrentDefectNum() < MAX_COUNT) {
                        System.out.println("Введите резюме дефекта");
                        String resume = scanner.nextLine();
                        System.out.println("Введите критичность дефекта (Blocker, Critical, Major, Minor, Trivial)");
                        String severity = scanner.nextLine();
                        System.out.println("Введите ожидаемое количество дней на исправление дефекта");
                        String daysToFix = scanner.nextLine();

                        Defect defect = new Defect(resume, severity, daysToFix);

                        Repository.add(defect);
                    }   else {
                        System.out.println("Нельзя ввести больше 10 дефектов!");
                    }
                    break;
                }

                case "list": {
                    System.out.println("Список дефектов:");
                    for (int i = 0; i < Repository.getCurrentDefectNum(); i++) {
                        System.out.println("ID: " + Repository.getAll()[i].getID() + " | " + "Резюме: " +
                                Repository.getAll()[i].getResume() + " | " + "Критичность: " +
                                Repository.getAll()[i].getSeverity() + " | " + "Дни: " +
                                Repository.getAll()[i].getDaysToFix());

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


