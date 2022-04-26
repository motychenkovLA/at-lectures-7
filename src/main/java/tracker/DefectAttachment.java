package tracker;

public class DefectAttachment extends Attachment {
    private String linkId; // todo 1 - можно зафиналить

    public DefectAttachment(String linkId) {
        this.linkId = linkId;
    }

    // todo 1 - аналогично замечанию в CommentAttachment
    @Override
    public String asString() {
        return linkId;
    }
}
