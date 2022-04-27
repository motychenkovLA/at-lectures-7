package tracker;

public class DefectAttachment extends Attachment {
    private final long linkId; // todo 1 - можно зафиналить -исправлено

    public DefectAttachment(long linkId) {

        this.linkId = linkId;
    }

    @Override
    public String asString() {
        return " , Ссылка на дефект по id: " + linkId;
    }
}
