package tracker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String choise;
        int count = 0;     //счетчик дефектов
        int maxCount = 3; //максимальное количество дефектов
        Defect[] defects = new Defect[maxCount];
        do {
            System.out.println("--------------" + "\n" +
                    "Для добавления дефекта введите add" + "\n"
                    + "Для вывода списка дефектов введите list" + "\n"
                    + "Для выхода из программы введите quit");
            choise = scanner.nextLine();
            switch (choise) {

                case "add": {
                    if (count < maxCount) {

                        System.out.println("Введите резюме дефекта:");
                        String summary = scanner.nextLine();
                        System.out.println("Введите критичность дефекта. Возможные варианты: блокирующий, высокий, средний, низкий");
                        String severity = scanner.nextLine();
                        System.out.println("Введите ожидаемое количество дней на исправление:");
                        int day = scanner.nextInt();
                        scanner.nextLine();
                        Defect defect = new Defect(count + 1, summary, severity, day);

                        defects[count] = defect;
                        count++;
                    } else System.out.println("Зарегистрировано максимально возможное количество дефектов");
                    break;

                }
                case "list": {
                    if (count != 0) {
                        //сделать for each не получилось - если заполнено меньше максимального кол-ва дефектов,
                        // вывод на экран возвращает ошибку, когда доходит до незаполненных элементов массива
                        for (int i = 0; i < count; i++) {
                            defects[i].printDefect();
                        }
                    }
                    break;
                }
            }

        }
        while (!choise.equals("quit"));

    }


}
