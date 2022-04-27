package tracker;

public class CommentAttachment extends Attachment {
    private String comment;

    public CommentAttachment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "Комментарий: "+comment;
    }
}
