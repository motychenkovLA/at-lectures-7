package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        final int MAX_CAPACITY = 2;

        Repository allDefects = new Repository(MAX_CAPACITY);

        boolean programRun = true;
        while (programRun) {
            System.out.println("������� �������:\n\"add\" - �������� ����� ������,\n" +
                    "\"list\" - ������� ������ ��������,\n" +
                    "\"quit\" - �����");
            Scanner scanner = new Scanner(System.in);
            String choiceCommand = scanner.nextLine();

            switch (choiceCommand) {
                case "add":
                    if (!allDefects.isFull()) {

                        System.out.println("������� �������� �������");
                        String description = scanner.nextLine();

                        System.out.println("������� ����������� �������:\nS1 - Blocker;\nS2 - Critical;" +
                                "\nS3 - Major;\nS4 - Minor;\nS5 - Trivial");
                        String severity = scanner.nextLine();

                        System.out.println("������� ����������� ���� ��� ����������� �������");
                        int numberOfDays = scanner.nextInt();

                        scanner.nextLine();

                        System.out.println("�������� ��� ��������:\n\"comment\" - ������ ����������� � �������,\n" +
                                "\"link\" - ������ �� ������ ������");
                        String choiceAttachment = scanner.nextLine();

                        switch (choiceAttachment) {
                            case "comment":
                                System.out.println("������� �����������:");
                                String comment = scanner.nextLine();
                                CommentAttachment commentAttachment = new CommentAttachment(comment);
                                Defect defect1 = new Defect(description, severity, numberOfDays, commentAttachment);
                                allDefects.add(defect1);
                                break;

                            case "link":
                                System.out.println("������� ������ �� ������:");
                                int link = scanner.nextInt();
                                DefectAttachment defectAttachment = new DefectAttachment(link);
                                Defect defect2 = new Defect(description, severity, numberOfDays, defectAttachment);
                                allDefects.add(defect2);
                                break;

                            default:
                                System.out.println("������ ���� �������� �� ����������");
                                break;
                        }

                    } else {
                        System.out.println("����������� �����!\n������� ������ �������!");
                        continue;
                    }
                    break;
                case "list":

                    Defect[] all = allDefects.getAll();

                    for (int a = 0; a <= (all.length - 1); a++) {
                        System.out.println(all[a].getId() + " | " + all[a].getSummary() + " | " +
                        all[a].getSeverity() + " | " + all[a].getDays() + " | "
                                + all[a].getAttachment().asString());
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

