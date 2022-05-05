package tracker;

public class DefectAttachment extends Attachment {

    private Long id;

    public DefectAttachment(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
