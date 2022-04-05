package tracker;

import java.util.Scanner;

public class Main {

//    нейминг переменных
//    магическое число 7
//    выход за границу левого поля
//    выравнивание

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите резюме дефекта");
        String name = scanner.nextLine();
        System.out.println("Введите критичность дефекта");
        System.out.println("Высокая, Средняя, Низкая");
        String name1 = scanner.nextLine();
        System.out.println("Введите срок исправления дефекта, в днях");
        int number = scanner.nextInt();
        scanner.nextLine();
       boolean result = number >7;
        System.out.println("Резюме дефекта: " + name + ", Критичность: " + name1 + ", Срок исправления: " +  number + " дней" + ", Займет больше рабочей недели: " + result);
    }

}
