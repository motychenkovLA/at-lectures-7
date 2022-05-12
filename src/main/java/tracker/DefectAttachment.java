package tracker;

public class DefectAttachment extends Attachment {

    private int idDefect;

    public DefectAttachment(int idDefect) {
        this.idDefect = idDefect;
    }

    public String toString() {
        return String.valueOf(idDefect);
    }
}
