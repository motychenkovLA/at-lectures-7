package tracker;

public class DefectAttachment extends Attachment {
    private String linkId;

    public DefectAttachment(String linkId) {
        this.linkId = linkId;
    }

    @Override
    public String asString() {
        return linkId;
    }
}
