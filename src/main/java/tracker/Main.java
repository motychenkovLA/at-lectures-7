package tracker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] array = new String[2];
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while (true) {
            System.out.println("Выберите действие:\n" + "(Добавить новый дефект - add, Вывести список - list, " +
                    "Выйти из программы - quit");
            switch (scanner.nextLine()) {
                case "add":
                    if (i >= array.length) {
                        System.out.println("Размер дефектов превышен");
                        break;
                    }
                    final int WORK_WEEK = 5;
                    System.out.println("//Создание баг-репорта//");
                    System.out.println("Введите название дефекта");
                    String name = scanner.nextLine();
                    System.out.println("Введите критичность дефекта:\n" + "(trivial, minor, major, critical, blocker)");
                    String critical = scanner.nextLine();
                    System.out.println("Введите ожидаемое кол-во дней на исправление дефекта");
                    int countDay = scanner.nextInt();
                    System.out.println("Исправление займет больше рабочей недели - " + (countDay > WORK_WEEK));
                    String defect = "Информация о заведенном дефекте:\nНомер дефекта - " + i +
                            "\nНазвание - " + name + "\nКритичность - " + critical +
                            "\nДней на исправление - " + countDay +
                            "\nИсправление займет больше рабочей недели - " + (countDay > WORK_WEEK);
                    array[i] = defect;
                    i++;
                    break;
                case "list":
                    System.out.println(Arrays.toString(array));
                    System.out.println();
                    break;
                case "quit":
                    System.out.println("Выход из программы");
                    return;
                default:
                    System.out.println("try again");
                    System.out.println();
            }
        }
    }
}