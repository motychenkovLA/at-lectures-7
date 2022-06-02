package tracker;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

import static tracker.Status.*;

public class Main {
    public static void main(String[] args) {
        Repository repository = new Repository();
        boolean programRun = true;
        try(Scanner scanner = new Scanner(System.in)) {
            while (programRun) {
                printMenu();
                String choiceCommand = scanner.nextLine();
                switch (choiceCommand) {
                    case "add": {
                        if (!repository.isFull()) {
                            add(repository, scanner);
                        } else {
                            System.out.println("����������� �����!\n������� ������ �������!");
                        }
                        break;
                    }
                    case "list": {
                        showList(repository.getAll());
                        break;
                    }
                    case "1": {
                        stats(repository.getAll());
                        break;

                    }
                    case "change": {
                        changeStatus(repository.getAll(), scanner);
                        break;
                    }
                    case "quit": {
                        programRun = false;
                        System.out.println("����! �������� �����");
                        break;
                    }
                    default: {
                        System.out.println("�������� �������! ���������� �����!");
                        break;
                    }
                }
            }
        }
    }

    private static void add(Repository repository, Scanner scanner) {
        System.out.println("������� �������� �������");
        String description = scanner.nextLine();
        Severity severity = Severity.valueOf("TRIVIAL");
        severity = inputSeverity(severity, scanner);
        int numberOfDays = 0;
        numberOfDays = inputNumberOfDays(numberOfDays, scanner);
        System.out.println("�������� ��� ��������:\n\"comment\" - ������ ����������� " +
                "� �������,\n\"link\" - ������ �� ������ ������");
        scanner.nextLine();
        String choiceAttachment;
        boolean runChooseAttachment = true;
        while (runChooseAttachment) {
            choiceAttachment = scanner.nextLine();
            switch (choiceAttachment) {
                case "comment": {
                    Defect defect1 = new Defect(description,
                            severity.ruName, numberOfDays, inputCommentAttachment(scanner));
                    repository.add(defect1);
                    runChooseAttachment = false;
                    break;
                }
                case "link": {
                    Defect defect2 = new Defect(description, severity.ruName,
                            numberOfDays, inputLinkAttachment(scanner));
                    repository.add(defect2);
                    runChooseAttachment = false;
                    break;
                }
                default: {
                    System.out.println("������ ���� �������� �� ����������");
                    break;
                }
            }
        }
    }

    private static void printMenu() {
        System.out.println("������� �������:\n\"add\" - �������� ����� ������,\n" +
                "\"list\" - ������� ������ ��������,\n" + "\"change\" - �������� ������ �������,\n" +
                 "\"stats\" - ������� ���������� �� ��������\n" + "\"quit\" - �����\n");
    }

    private static Severity inputSeverity(Severity severity, Scanner scanner) {
        System.out.println("������� ����������� �������:\nBLOCKER (�����������);\nCRITICAL" +
                " (�����������);" +
                "\nMAJOR (������������);\nMINOR (��������������);\nTRIVIAL (�����������)");
        boolean runInputSeverity = true;
        while (runInputSeverity) {
            try {
                severity = Severity.valueOf(scanner.nextLine());
                runInputSeverity = false;
            } catch (IllegalArgumentException e) {
                System.out.println("�������� ��������. ������� �������� �� ������");
            }
        }
        return severity;
    }

    private static int inputNumberOfDays(int number, Scanner scanner) {
        System.out.println("������� ����������� ���� ��� ����������� �������");
        boolean runInputNumberOfDays = true;
        while (runInputNumberOfDays) {

            try {
                number = scanner.nextInt();
                runInputNumberOfDays = false;

            } catch (InputMismatchException y) {

                System.out.println("�������� ��������. ����� ������� �����.");
                System.out.println("���������� ��� ���");
                scanner.nextLine();
            }
        }
        return number;
    }

    private static @NotNull CommentAttachment inputCommentAttachment(Scanner scanner) {
        System.out.println("������� �����������:");
        String comment = scanner.nextLine();
        return new CommentAttachment(comment);
    }

    private static DefectAttachment inputLinkAttachment(Scanner scanner) {
        boolean runInputLink = true;
        int link;
        DefectAttachment linkAttachment = null;
        while (runInputLink) {
            System.out.println("������� ������ �� ������:");
            try {
                link = scanner.nextInt();
                linkAttachment = new DefectAttachment(link);
                scanner.nextLine();
                runInputLink = false;

            } catch (InputMismatchException y) {
                System.out.println("������� ������������ ��������!");
                System.out.println("���������� ��� ���!");
                scanner.nextLine();
            }
        }

        return linkAttachment;
    }

    private static void showList(Map<Long,Defect> repository) {
        for (Map.Entry<Long, Defect> entry : repository.entrySet()) {
            Defect defect = entry.getValue();
            System.out.println(entry.getKey()  + " | ��������: " + defect.getSummary() +
                    " | �����������: " + defect.getSeverity() + " | ���������� ���� ��� " +
                    "�����������: " + defect.getDays() + " | " + defect.getAttachment().toString() +
                    " | ������: " + defect.getStatus().ruName);
        }
    }

    private static void changeStatus(Map<Long,Defect> repository, Scanner scanner) {

        Set<Transition> statusesTransition = new HashSet<>();
        statusesTransition.add(new Transition(OPEN, ANALYSIS));
        statusesTransition.add(new Transition(ANALYSIS, FIXED));
        statusesTransition.add(new Transition(ANALYSIS, CLOSED));
        statusesTransition.add(new Transition(FIXED, TEST));
        statusesTransition.add(new Transition(TEST, CLOSED));
        statusesTransition.add(new Transition(TEST, ANALYSIS));


        long id;
        System.out.println("������� id ������� �� ������ " + (repository.size() - 1));
        boolean runInputId = true;
        while (runInputId) {
            try {
                id = scanner.nextInt();

                if (id < repository.size()) {

                    scanner.nextLine();
                    System.out.println("������� ������ �������:\n" +
                            "\"OPEN\" - ������,\n\"CLOSED\" - ������\n" +
                            "\"ANALYSIS\" - � �������,\n\"TEST\" - ������������\n" +
                            "\"FIXED\" - ����������");
                    boolean runInputStatusDefect = true;

                    while (runInputStatusDefect) {
                        try {
                            Defect defect = repository.get(id);
                            Status newStatus = Status.valueOf(scanner.nextLine());
                            if (statusesTransition.contains(new Transition(defect.getStatus(), newStatus))) {

                                    defect.setStatus(String.valueOf(newStatus));
                                    runInputStatusDefect = false;

                            } else {
                                System.out.println("������ ��������� ������ � ���� ������!\n" +
                                        "���������� �����!");
                                System.out.println("������ ��������� ��������� ��������:\n ");
                                for (Transition el : statusesTransition) {
                                    System.out.println(el.from + " / " + el.from.ruName + " -> " +
                                            el.to + " / " + el.to.ruName);
                                }
                            }
                        } catch (IllegalArgumentException e) {
                                System.out.println("����� ������ ���������� ������! ");
                        }
                    }
                } else {
                    System.out.println("��� ������� � ����� id");
                    scanner.nextLine();
                }

                runInputId = false;

            } catch (InputMismatchException i) {
                System.out.println("������� �������� �� 0 �� " + (repository.size() - 1)
                        + " ������������");
                scanner.nextLine();
            }
        }
    }

    private static void stats(Map<Long,Defect> repository) {
        List<Integer> days = new ArrayList<>();
        List<Status> statuses = new ArrayList<>();
        for (Map.Entry<Long, Defect> entry : repository.entrySet()) {
            days.add(entry.getValue().getDays());
            statuses.add(entry.getValue().getStatus());
        }

        DoubleSummaryStatistics daysStats = days.stream()
                .mapToDouble(Integer::intValue)
                .summaryStatistics();

        Map<String, Long> stats = new HashMap<>();
        for (Status el : statuses) {
            stats.put(String.valueOf(el), statuses.stream().filter(q -> q.equals(Status.valueOf(String.valueOf(el)))).count());
        }

        System.out.println("������������ ���������� ����: " + daysStats.getMax() +
                "\n������� ���������� ����: " +  daysStats.getAverage()+
                "\n����������� ���������� ����: " + daysStats.getMin());

        for (Map.Entry<String, Long> entry : stats.entrySet()) {
            System.out.println(" ������: " + entry.getKey() + " / " + "���������� �������� � ���� �������: " +
                    entry.getValue());
        }

    }
}

