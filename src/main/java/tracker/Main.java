package tracker;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int MAX_COUNT = 10;
        Repository repository = new Repository(MAX_COUNT);

        boolean isRun = true;
        while(isRun) {
            System.out.println("Выберите действие: " + "\n" + "add - добавить новый дефект" + "\n" +
                    "change - изменить статус" + "\n" + "list - вывести список" + "\n" + "quit - выйти из программы");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextLine()) {
                case "add": {
                    if (repository.isFull()) {
                        System.out.println("Введите резюме дефекта");
                        String resume = scanner.nextLine();
                        System.out.println("Введите критичность дефекта (BLOCKER, CRITICAL, MAJOR, MINOR, TRIVIAL)");
                        Severity severity = Severity.valueOf(scanner.nextLine());
                        System.out.println("Введите ожидаемое количество дней на исправление дефекта");
                        String daysToFix = scanner.nextLine();
                        System.out.println("Выберите тип вложения: comment - коментарий, link - ссылка на другой " +
                                "дефект");
                        switch (scanner.nextLine()) {
                            case "comment": {
                                System.out.println("Введите комментарий");
                                String comment = scanner.nextLine();
                                CommentAttachment commentAttachment = new CommentAttachment(comment);
                                Defect defect = new Defect(resume, severity, daysToFix, commentAttachment, Status.OPEN);
                                repository.add(defect);
                                break;
                            }
                            case "link": {
                                System.out.println("Введите ID дефекта");
                                long link = scanner.nextLong();
                                DefectAttachment defectAttachment = new DefectAttachment(link);
                                Defect defect = new Defect(resume, severity, daysToFix, defectAttachment, Status.OPEN);
                                repository.add(defect);
                                break;
                            }
                        }

                    }   else {
                        System.out.println("Нельзя ввести больше 10 дефектов!");
                    }
                    break;
                }

                case "change": {
                    System.out.println("Введите id дефекта");
                    long defectID = scanner.nextLong();
                    System.out.println("Выберите новый статус (OPEN, FIXING, TESTING, CLOSED, REJECTED)");
                    Status status = Status.valueOf(scanner.nextLine());
                    for (int i = 0; i < repository.getCurrentDefectNum(); i++) {
                        if (i == defectID) {
                            repository.getAll()[i].setStatus(status);
                        }
                    }

                    break;
                }

                case "list": {
                    System.out.println("Список дефектов:");
                    for (int i = 0; i < repository.getCurrentDefectNum(); i++) {
                        System.out.println("ID: " + repository.getAll()[i].getID() + " | Резюме: " +
                                repository.getAll()[i].getResume() + " | Критичность: " +
                                repository.getAll()[i].getSeverity() + " | Дни: " +
                                repository.getAll()[i].getDaysToFix() + " | Статус: " +
                                repository.getAll()[i].getStatus() + " | Вложение: " +
                                repository.getAll()[i].getAttachment().toString());

                    }
                    break;
                }

                case "quit": {
                    isRun = false;
                    break;
                }
                default: {
                    System.out.println("Введено неверное значение, попробуйте еще раз.");
                    break;
                }
            }
        }
    }
}


