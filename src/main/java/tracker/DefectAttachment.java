package tracker;

public class DefectAttachment extends Attachment {
    private int linkId;

    public DefectAttachment(int linkId) {
        this.linkId = linkId;
    }

    public int getId() {
        return linkId;
    }

    @Override
    public String toString() {
        return "Ссылка на дефект по id: "+linkId;
    }
}
