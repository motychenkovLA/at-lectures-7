package tracker;

import java.util.Objects;

public class CommentAttachment extends Attachment {
    private final String comment;

    public CommentAttachment(String comment) {
        this.comment = comment;
    }

    public String toString() {
        return "Комментарий: " + comment;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CommentAttachment commentAttachment = (CommentAttachment) obj;
        return this.comment.equals(commentAttachment.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comment);
    }

}

