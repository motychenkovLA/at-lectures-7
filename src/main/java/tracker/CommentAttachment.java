package tracker;

public class CommentAttachment extends Attachment {
    public String comment;

    public CommentAttachment(long defectID, String comment) {
        super(defectID);
        this.comment = comment;
    }

    @Override
    public String asString() {

        return this.comment;
    }
}
