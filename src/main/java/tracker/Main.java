package tracker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String choise;
        int count=0;     //счетчик дефектов
        int maxCount=10; //максимальное количество дефектов
        Defect [] defects = new Defect[maxCount];
        do {
            System.out.println("--------------"+"\n"+
                    "Для добавления дефекта введите add"+"\n"
                    +"Для вывода списка дефектов введите list"+"\n"
                    +"Для выхода из программы введите quit");
       choise=scanner.nextLine();
        switch (choise) {

            case "add": {
                if (count < maxCount) {

                    defects[count] = new Defect(count+1);

                    count++;
                }
                else System.out.println("Зарегистрировано максимально возможное количество дефектов");
                break;

            }
            case "list": {  if (count != 0) {
                for (int i = 0; i < count; i++) {
                   defects[i].printDefect();
                }
            }
            }break;
        }

        }
      while (!choise.equals("quit"));

    }
}
