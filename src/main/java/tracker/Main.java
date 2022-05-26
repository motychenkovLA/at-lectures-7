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
                menu();
                String choiceCommand = scanner.nextLine();
                switch (choiceCommand) {
                    case "add": {
                        if (!repository.isFull()) {
                            System.out.println("������� �������� �������");
                            String description = scanner.nextLine();
                            Severity severity = Severity.valueOf("TRIVIAL");
                            severity = inputSeverity(severity);
                            int numberOfDays = 0;
                            numberOfDays = inputNumberOfDays(numberOfDays);
                            System.out.println("�������� ��� ��������:\n\"comment\" - ������ ����������� " +
                                    "� �������,\n\"link\" - ������ �� ������ ������");
                            String choiceAttachment;
                            boolean runChooseAttachment = true;
                            while (runChooseAttachment) {
                                choiceAttachment = scanner.nextLine();
                                switch (choiceAttachment) {
                                    case "comment":
                                        Defect defect1 = new Defect(description,
                                                severity.ruName, numberOfDays, inputCommentAttachment());
                                        repository.add(defect1);
                                        runChooseAttachment = false;
                                        break;
                                    case "link":
                                        Defect defect2 = new Defect(description, severity.ruName,
                                                numberOfDays, inputLinkAttachment());
                                        repository.add(defect2);
                                        runChooseAttachment = false;
                                        break;
                                    default:
                                        System.out.println("������ ���� �������� �� ����������");
                                        break;
                                }
                            }
                        } else {
                            System.out.println("����������� �����!\n������� ������ �������!");
                            continue;
                        }
                        break;
                    }
                    case "list": {
                        Defect[] all = repository.getAll();
                        showList(all);
                        break;
                    }
                    case "change": {
                        Defect[] massiveWithDefects = repository.getAll();
                        changeStatus(massiveWithDefects);
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

    public static void menu() {
        System.out.println("������� �������:\n\"add\" - �������� ����� ������,\n" +
                "\"list\" - ������� ������ ��������,\n" + "\"change\" - �������� ������ �������,\n" +
                "\"quit\" - �����");
    }

    public static Severity inputSeverity(Severity severity) {
        System.out.println("������� ����������� �������:\nBLOCKER (�����������);\nCRITICAL" +
                " (�����������);" +
                "\nMAJOR (������������);\nMINOR (��������������);\nTRIVIAL (�����������)");
        boolean runInputSeverity = true;
        while (runInputSeverity) {
            try {
                Scanner scanner = new Scanner(System.in);
                severity = Severity.valueOf(scanner.nextLine());
                runInputSeverity = false;
            } catch (IllegalArgumentException e) {
                System.out.println("�������� ��������. ������� �������� �� ������");
            }
        }
        return severity;
    }

    public static int inputNumberOfDays(int number) {
        System.out.println("������� ����������� ���� ��� ����������� �������");
        boolean runInputNumberOfDays = true;
        while (runInputNumberOfDays) {

            try {
                Scanner scanner = new Scanner(System.in);
                number = scanner.nextInt();
                runInputNumberOfDays = false;

            } catch (InputMismatchException y) {

                System.out.println("�������� ��������. ����� ������� �����.");
                System.out.println("���������� ��� ���");
            }
        }
        return number;
    }

    public static @NotNull CommentAttachment inputCommentAttachment() {
        System.out.println("������� �����������:");
        Scanner scanner = new Scanner(System.in);
        String comment = scanner.nextLine();
        return new CommentAttachment(comment);
    }

    public static DefectAttachment inputLinkAttachment() {
        boolean runInputLink = true;
        int link;
        DefectAttachment linkAttachment = null;
        Scanner scanner = new Scanner(System.in);
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

    public static void showList(Defect @NotNull [] repository) {
        for (int a = 0; a <= (repository.length - 1); a++) {
            System.out.println(repository[a].getId() + " | ��������: " + repository[a].getSummary() +
                    " | �����������: " + repository[a].getSeverity() + " | ���������� ���� ��� " +
                    "�����������: " +
                    repository[a].getDays() + " | " + repository[a].getAttachment().toString() +
                    " | ������: " + repository[a].getStatus().ruName);
        }
    }

    public static void changeStatus(Defect @NotNull []  repository) {
        int id;
        boolean runInputId = true;
        System.out.println("������� id ������� �� 0 �� " + (repository.length - 1));
        Scanner scanner = new Scanner(System.in);
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

