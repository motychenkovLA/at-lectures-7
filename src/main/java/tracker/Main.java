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
        // todo 1 - week это константа --- УЧТЕНО
        final int WEEK = 5;
        // todo 1 - желательно это все в один sout собрать --- УЧТЕНО
        // todo 1 - нужно чтоб оно не вылезало за белую линию и экран --- УЧТЕНО
        System.out.println("Резюме: " + resume + "\nКритичность: " + crit +
                "\nСрок устранения: " + days +
                "\nУстранение займет больше рабочей недели?\n" +  (days > WEEK));
    }
}


