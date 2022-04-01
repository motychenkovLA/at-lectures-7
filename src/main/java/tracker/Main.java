package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int WORK_WEEK = 5;
        System.out.println("//Создание баг-репорта//");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название дефекта");
        String name = scanner.nextLine();
        System.out.println("Введите критичность дефекта:\n" + "(trivial, minor, major, critical, blocker)");
        String critical = scanner.nextLine();
        System.out.println("Введите ожидаемое кол-во дней на исправление дефекта");
        int countDay = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Информация о заведенном дефекте:\n"+"Название - " +name+"\n"+"Критичность - "+critical+"\n"+"Дней на исправление - "+countDay+"\n"+"Исправление займет больше рабочей недели - "+(countDay>WORK_WEEK));
    }
}
