package tracker;

public class CommentAttachment extends Attachment {

    public String comment;

    public CommentAttachment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "����������� � �������: " + this.comment;
    }
}
