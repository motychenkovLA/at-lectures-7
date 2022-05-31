package tracker;

public class DefectAttachment extends Attachment {

    private int linkToDef;

    public DefectAttachment(int linkId) {
        this.linkToDef = linkId;
    }

    @Override
    public String toString() {
        return "| Ссылка на дефект: " + linkToDef;
    }

}
