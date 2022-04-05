package tracker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String choise;
        int count=0;     //текущий номер дефекта, считает с 0
        int maxCount=10; //максимальное количество дефектов
        String [] summary = new String[maxCount];
        String [] severity= new String[maxCount];
        int [] day = new int [maxCount];
        do {
            System.out.println("--------------"+"\n"+
                    "Для добавления дефекта введите add"+"\n"
                    +"Для вывода списка дефектов введите list"+"\n"
                    +"Для выхода из программы введите quit");
       choise=scanner.nextLine();
        switch (choise) {

            case "add": {
                if (count < maxCount) {
                    System.out.println("Введите резюме дефекта:");
                    summary[count] = scanner.nextLine();
                    System.out.println("Введите критичность дефекта. Возможные варианты: блокирующий, высокий, средний, низкий");
                    severity[count] = scanner.nextLine();

                    System.out.println("Введите ожидаемое количество дней на исправление:");
                    day [count] = scanner.nextInt();
                    scanner.nextLine();
                    count++;
                }
                else System.out.println("Зарегистрировано максимально возможное количество дефектов");
                break;

            }
            case "list": {for (int i=0;i<count;i++)
            {
                System.out.println( i+" | "+ summary[i]+" | "
                        + severity[i] +" | "+ day[i]);

            }
            }break;
        }

        }
      while (!choise.equals("quit"));

    }
}
