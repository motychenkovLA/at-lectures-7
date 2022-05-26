package tracker;
import org.jetbrains.annotations.NotNull;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int MAX_CAPACITY = 2;
        Repository repository = new Repository(MAX_CAPACITY);
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
                        Defect[] all = repository.getAll();
                        showList(all);
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

    private static void showList(Defect @NotNull [] repository) {
        for (int a = 0; a <= (repository.length - 1); a++) {
            System.out.println(repository[a].getId() + " | ��������: " + repository[a].getSummary() +
                    " | �����������: " + repository[a].getSeverity() + " | ���������� ���� ��� " +
                    "�����������: " +
                    repository[a].getDays() + " | " + repository[a].getAttachment().toString() +
                    " | ������: " + repository[a].getStatus().ruName);
        }
    }

    private static void changeStatus(Defect @NotNull [] repository, Scanner scanner) {
        int id;
        boolean runInputId = true;
        System.out.println("������� id ������� �� 0 �� " + (repository.length - 1));
        while (runInputId) {

            try {
                id = scanner.nextInt();

                if (id < repository.length) {

                    System.out.println("������� ������ �������:\n" +
                            "\"OPEN\" - ������,\n\"CLOSED\" - ������");
                    scanner.nextLine();
                    boolean runInputStatusDefect = true;

                    while (runInputStatusDefect) {
                        try {
                            repository[id].setStatus(scanner.nextLine());
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
                System.out.println("������� �������� �� 0 �� " + (repository.length - 1)
                        + " ������������");
                scanner.nextLine();
            }
        }
    }
}

