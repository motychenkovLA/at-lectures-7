package tracker;

import java.util.Objects;

public class CommentAttachment extends Attachment {

    private String comment;

    public CommentAttachment(String comment) {
        this.comment = comment;
    }

    public String toString() {
        return comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentAttachment that = (CommentAttachment) o;
        if (this.hashCode() != o.hashCode()) return false;
        return comment.equals(that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comment);
    }
}
