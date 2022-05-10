package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        final int MAX_CAPACITY = 2;

        Repository allDefects = new Repository(MAX_CAPACITY);

        boolean programRun = true;
        while (programRun) {
            System.out.println("������� �������:\n\"add\" - �������� ����� ������,\n" +
                    "\"list\" - ������� ������ ��������,\n" + "\"change\" - �������� ������ �������,\n" +
                    "\"quit\" - �����");
            Scanner scanner = new Scanner(System.in);
            String choiceCommand = scanner.nextLine();

            switch (choiceCommand) {
                case "add":
                    if (!allDefects.isFull()) {

                        System.out.println("������� �������� �������");
                        String description = scanner.nextLine();

                        System.out.println("������� ����������� �������:\nBLOCKER (�����������);\nCRITICAL" +
                                " (�����������);" +
                                "\nMAJOR (������������);\nMINOR (��������������);\nTRIVIAL (�����������)");
                        Severity severity = Severity.valueOf(scanner.nextLine());

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
                                Defect defect1 = new Defect(description, severity.ruName, numberOfDays, commentAttachment);
                                allDefects.add(defect1);
                                break;

                            case "link":
                                System.out.println("������� ������ �� ������:");
                                int link = scanner.nextInt();
                                DefectAttachment defectAttachment = new DefectAttachment(link);
                                Defect defect2 = new Defect(description, severity.ruName, numberOfDays, defectAttachment);
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
                        System.out.println(all[a].getId() + " | ��������: " + all[a].getSummary() +
                                " | �����������: " + all[a].getSeverity() + " | ���������� ���� ��� �����������: " +
                                all[a].getDays() + " | " + all[a].getAttachment().toString() +
                                " | ������: " + all[a].getStatus().ruName);
                    }
                    break;

                case "change":

                    Defect[] massiveWithDefects = allDefects.getAll();
                    System.out.println("������� id �������: ");
                    int id = scanner.nextInt();

                    System.out.println("������� ������ �������:\n" +
                            "\"OPEN\" - ������,\n\"CLOSED\" - ������");
//                    System.out.println(massiveWithDefects[id].getStatus());

                    scanner.nextLine();

                    massiveWithDefects[id].setStatus(scanner.nextLine());
//                    System.out.println(massiveWithDefects[id].getStatus());

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

