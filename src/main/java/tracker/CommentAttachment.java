package tracker;

public class CommentAttachment extends Attachment {
    private final String comment;

    public CommentAttachment(String comment) {
        this.comment = comment;
    }

    public String asString() {
        return "Комментарий: " + comment;
    }
}
