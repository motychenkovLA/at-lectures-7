package tracker;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Repository repository = new Repository();
        try (Scanner scanner = new Scanner(System.in)) {
            boolean isRun = true;
            while (isRun) {
                System.out.println("Выберите действие: " + "\n" + "add - добавить новый дефект" + "\n" +
                        "change - изменить статус" + "\n" + "list - вывести список" + "\n" +
                        "stats - показать статистику" + "\n" + "quit - выйти из программы");
                switch (scanner.nextLine()) {
                    case "add": {
                        if (repository.isFull()) {
                            try {
                                System.out.println("Введите резюме дефекта");
                                String resume = scanner.nextLine();
                                System.out.println("Введите критичность дефекта (BLOCKER, CRITICAL, MAJOR, MINOR, " +
                                        "TRIVIAL)");
                                Severity severity = Severity.valueOf(scanner.nextLine());
                                System.out.println("Введите ожидаемое количество дней на исправление дефекта");
                                int daysToFix = Integer.parseInt(scanner.nextLine());
                                System.out.println("Выберите тип вложения: comment - коментарий, link - ссылка " +
                                        "на другой дефект");
                                switch (scanner.nextLine()) {
                                    case "comment": {
                                        System.out.println("Введите комментарий");
                                        String comment = scanner.nextLine();
                                        CommentAttachment commentAttachment = new CommentAttachment(comment);
                                        Defect defect = new Defect(resume, severity, daysToFix, commentAttachment,
                                                Status.OPEN);
                                        repository.add(defect);
                                        break;
                                    }
                                    case "link": {
                                        boolean addLink = true;
                                        while (addLink) {
                                            try {
                                                System.out.println("Введите ID дефекта");
                                                long link = Long.parseLong(scanner.nextLine());
                                                DefectAttachment defectAttachment = new DefectAttachment(link);
                                                Defect defect = new Defect(resume, severity, daysToFix,
                                                        defectAttachment, Status.OPEN);
                                                repository.add(defect);
                                                addLink = false;
                                            } catch (NumberFormatException e) {
                                                System.out.println("Введите число!");
                                            }
                                        }
                                        break;
                                    }
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Введите число!");
                            } catch (IllegalArgumentException e) {
                                System.out.println("Неверное значение! Выберите значение из списка.");
                            }
                        } else {
                            System.out.println("Нельзя ввести больше 10 дефектов!");
                        }
                        break;
                    }

                    case "change": {
                        Set<Transition> setTransition = new HashSet<>();
                        setTransition.add(new Transition(Status.OPEN, Status.FIXING));
                        setTransition.add(new Transition(Status.FIXING, Status.TESTING));
                        setTransition.add(new Transition(Status.TESTING, Status.CLOSED));
                        boolean isChanging = true;
                        while (isChanging) {
                            try {
                                System.out.println("Введите id дефекта");
                                long defectID = Long.parseLong(scanner.nextLine());
                                if (repository.getAll().containsKey(defectID)) {
                                    System.out.println("Выберите новый статус (OPEN, FIXING, TESTING, CLOSED)");
                                    Status status = Status.valueOf(scanner.nextLine());
                                    if (setTransition.contains(new Transition(repository.getAll().get(defectID)
                                            .getStatus(), status))) {
                                        repository.getAll().get(defectID).setStatus(status);
                                    } else {
                                        System.out.println("Невалидный переход между статусами!");
                                    }
                                } else {
                                    System.out.println("Дефект с id = " + defectID + " не найден!");
                                }
                                isChanging = false;
                            } catch (NumberFormatException e) {
                                System.out.println("Введите число!");
                            } catch (IllegalArgumentException e) {
                                System.out.println("Неверное значение! Выберите значение из списка: OPEN, FIXING, " +
                                        "TESTING, CLOSED");
                            }
                        }
                        break;
                    }

                    case "list": {
                        System.out.println("Список дефектов:");
                        for (Map.Entry<Long, Defect> entry : repository.getAll().entrySet()) {
                            System.out.println(entry.getValue());
                        }
                        break;
                    }

                    case "stats": {
                        IntSummaryStatistics stats = repository.getAll().values().stream()
                                .mapToInt(Defect::getDaysToFix).summaryStatistics();
                        int maxDay = stats.getMax();
                        int minDay = stats.getMin();
                        double average = stats.getAverage();

                        long open = repository.getAll().values().stream().filter(e -> e.getStatus()
                                .equals(Status.OPEN)).count();
                        long fixing = repository.getAll().values().stream().filter(e -> e.getStatus()
                                .equals(Status.FIXING)).count();
                        long testing = repository.getAll().values().stream().filter(e -> e.getStatus()
                                .equals(Status.TESTING)).count();
                        long closed = repository.getAll().values().stream().filter(e -> e.getStatus()
                                .equals(Status.CLOSED)).count();

                        System.out.println("Максимальное кол-во дней на исправление: " + maxDay + "\n" +
                                "Минимальное кол-во дней на исправление: " + minDay + "\n" +
                                "Среднее кол-во дней на исправление: " + average + "\n" +
                                "Количество дефектов по статусам:" + "\n" + "Открыт - " + open + "\n" +
                                "На исправлении - " + fixing + "\n" + "В тестировании - " + testing + "\n" +
                                "Закрыт - " + closed);
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
}


