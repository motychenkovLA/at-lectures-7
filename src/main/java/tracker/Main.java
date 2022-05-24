package tracker;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int MAX_CAPACITY = 2;

        Repository allDefects = new Repository(MAX_CAPACITY);

        boolean programRun = true;
        try(Scanner scanner = new Scanner(System.in)) {
            while (programRun) {
                System.out.println("������� �������:\n\"add\" - �������� ����� ������,\n" +
                        "\"list\" - ������� ������ ��������,\n" + "\"change\" - �������� ������ �������,\n" +
                        "\"quit\" - �����");
                String choiceCommand = scanner.nextLine();

                switch (choiceCommand) {
                    case "add":
                        if (!allDefects.isFull()) {

                            System.out.println("������� �������� �������");
                            String description = scanner.nextLine();

                            System.out.println("������� ����������� �������:\nBLOCKER (�����������);\nCRITICAL" +
                                    " (�����������);" +
                                    "\nMAJOR (������������);\nMINOR (��������������);\nTRIVIAL (�����������)");

                            boolean runInputSeverity = true;
                            Severity severity = Severity.valueOf("TRIVIAL");
                            while(runInputSeverity) {
                                try {
                                    severity = Severity.valueOf(scanner.nextLine());
                                    runInputSeverity = false;

                                } catch(IllegalArgumentException e) {
                                    System.out.println("�������� ��������. ������� �������� �� ������");
                                }
                            }

                            System.out.println("������� ����������� ���� ��� ����������� �������");

                            int numberOfDays = 0;
                            boolean runInputNumberOfDays = true;
                            while(runInputNumberOfDays) {

                                try {
                                    numberOfDays = scanner.nextInt();
                                    runInputNumberOfDays = false;

                                } catch(InputMismatchException y) {

                                    System.out.println("�������� ��������. ����� ������� �����.");
                                    System.out.println("���������� ��� ���");
                                    scanner.nextLine();
                                }
                            }

                            scanner.nextLine();

                            System.out.println("�������� ��� ��������:\n\"comment\" - ������ ����������� " +
                                    "� �������,\n\"link\" - ������ �� ������ ������");
                            String choiceAttachment;

                            boolean runChooseAttachment = true;
                            while(runChooseAttachment) {

                                choiceAttachment = scanner.nextLine();

                                switch (choiceAttachment) {
                                    case "comment":
                                        System.out.println("������� �����������:");
                                        String comment = scanner.nextLine();
                                        CommentAttachment commentAttachment = new CommentAttachment(comment);
                                        Defect defect1 = new Defect(description,
                                                        severity.ruName, numberOfDays, commentAttachment);
                                        allDefects.add(defect1);
                                        runChooseAttachment = false;
                                        break;
                                    case "link":
                                        boolean runInputLink = true;
                                        while(runInputLink) {
                                            System.out.println("������� ������ �� ������:");
                                            try {
                                                int link = scanner.nextInt();
                                                DefectAttachment defectAttachment = new DefectAttachment(link);
                                                Defect defect2 = new Defect(description, severity.ruName,
                                                        numberOfDays, defectAttachment);
                                                allDefects.add(defect2);
                                                scanner.nextLine();
                                                runInputLink = false;

                                            } catch(InputMismatchException y) {
                                                System.out.println("������� ������������ ��������!");
                                                System.out.println("���������� ��� ���!");
                                                scanner.nextLine();
                                            }
                                        }
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
                    case "list":

                        Defect[] all = allDefects.getAll();

                        for (int a = 0; a <= (all.length - 1); a++) {
                            System.out.println(all[a].getId() + " | ��������: " + all[a].getSummary() +
                                    " | �����������: " + all[a].getSeverity() + " | ���������� ���� ��� " +
                                    "�����������: " +
                                    all[a].getDays() + " | " + all[a].getAttachment().toString() +
                                    " | ������: " + all[a].getStatus().ruName);
                            System.out.println(all[a].hashCode());
                        }
                        break;

                    case "change":

                        Defect[] massiveWithDefects = allDefects.getAll();
                        int id;
                        boolean runInputId = true;
                        System.out.println("������� id ������� �� 0 �� " + (massiveWithDefects.length-1));

                        while(runInputId) {

                            try {
                                id = scanner.nextInt();

                                if (id < massiveWithDefects.length) {

                                    System.out.println("������� ������ �������:\n" +
                                            "\"OPEN\" - ������,\n\"CLOSED\" - ������");
                                    scanner.nextLine();
                                    boolean runInputStatusDefect = true;

                                    while(runInputStatusDefect) {
                                            try {
                                                massiveWithDefects[id].setStatus(scanner.nextLine());
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

                            } catch(InputMismatchException i) {
                               System.out.println("������� �������� �� 0 �� " + (massiveWithDefects.length-1)
                                       + " ������������");
                               scanner.nextLine();
                            }

                        }
                        break;
                    case "quit":
                        programRun = false;
                        System.out.println("����! �������� �����");
                        break;

                    default:
                        System.out.println("�������� �������! ���������� �����!");
                        break;
                }
            }
        }
    }
}

