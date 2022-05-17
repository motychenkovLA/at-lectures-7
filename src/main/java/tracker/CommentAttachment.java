package tracker;

import java.util.Objects;

public class CommentAttachment extends Attachment {
    private final String comment;

    public CommentAttachment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public String asString() {
        return "Комментарий: " + comment;
    }

    @Override
    public boolean equals(Object a) {
        if (this == a) return true;
        if (a == null || getClass() != a.getClass()) return false;
        CommentAttachment comment = (CommentAttachment) a;
        if (this.hashCode() != comment.hashCode()) return false;
        return this.equals(comment.getComment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(comment);
    }
}
