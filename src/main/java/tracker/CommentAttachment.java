package tracker;

import java.util.Objects;

public class CommentAttachment extends Attachment {
    private final String comment;

    public CommentAttachment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Комментарий - " + comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CommentAttachment commentAttachment = (CommentAttachment) o;
        if (this.hashCode() != commentAttachment.hashCode()) return false;
        return this.comment.equals(commentAttachment.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comment);
    }
}
