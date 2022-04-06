package tracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите резюме дефекта:");
        String resume = scanner.nextLine();
        System.out.println("Укажите критичность, \nHigh   Medium    Low:");
        String crit = scanner.nextLine();
        System.out.println("Введите, сколько дней потребуется для устранения:");
        int days = scanner.nextInt();
        scanner.nextLine();
        // todo 1 - week это константа
        int week = 5;
        // todo 1 - желательно это все в один sout собрать
        // todo 1 - нужно чтоб оно не вылезало за белую линию и экран
        System.out.println("Резюме: " + resume + "\nКритичность: " + crit + "\nСрок устранения: " + days + "\nУстранение займет больше рабочей недели?");
        System.out.println(days > week);
    }
}
