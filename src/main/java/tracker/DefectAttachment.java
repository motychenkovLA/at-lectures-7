package tracker;

public class DefectAttachment extends Attachment {
    private final long linkId;

    public DefectAttachment(long linkId) {

        this.linkId = linkId;
    }

    @Override
    public String asString() {
        return "Ссылка на дефект по id: " + linkId;
    }

    // todo 3 - ТЗ: реализовать методы equals(...) и hashCode() у Defect и Attachment-ов
}
