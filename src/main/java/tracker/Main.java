package tracker;
import org.jetbrains.annotations.NotNull;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

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
                "\"quit\" - �����");
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
//        for (int a = 0; a <= (repository.length - 1); a++) {
//            System.out.println(repository[a].getId() + " | ��������: " + repository[a].getSummary() +
//                    " | �����������: " + repository[a].getSeverity() + " | ���������� ���� ��� " +
//                    "�����������: " +
//                    repository[a].getDays() + " | " + repository[a].getAttachment().toString() +
//                    " | ������: " + repository[a].getStatus().ruName);
//        }
        for (Map.Entry<Long, Defect> entry : repository.entrySet()) {
            Defect defect = entry.getValue();
            System.out.println(entry.getKey()  + " | ��������: " + defect.getSummary() +
                    " | �����������: " + defect.getSeverity() + " | ���������� ���� ��� " +
                    "�����������: " + defect.getDays() + " | " + defect.getAttachment().toString() +
                    " | ������: " + defect.getStatus().ruName);
        }
    }

    private static void changeStatus(Map<Long,Defect> repository, Scanner scanner) {
        long id;
        System.out.println("������� id ������� �� ������ " + (repository.size() - 1));
        boolean runInputId = true;
        while (runInputId) {
            try {
                id = scanner.nextInt();

                if (id < repository.size()) {

                    System.out.println("������� ������ �������:\n" +
                            "\"OPEN\" - ������,\n\"CLOSED\" - ������");
                    scanner.nextLine();
                    boolean runInputStatusDefect = true;

                    while (runInputStatusDefect) {
                        try {
                            Defect defect = repository.get(id);
                            defect.setStatus(scanner.nextLine());
                            runInputStatusDefect = false;

                        } catch (IllegalArgumentException e) {
                            System.out.println("����� ������ ���������� ������! " +
                                    "���������� ��� ���!");
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
}

