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

    @Override
    public String toString() {
        return "Комментарий: " + comment;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null || this.getClass() != o.getClass()) return false;
        if(this == o) return true;
        if(this.hashCode() != o.hashCode()) return false; // todo 1 - лишняя проверка
        CommentAttachment commentAttachment = (CommentAttachment) o;
        return this.comment.equals(commentAttachment.getComment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getComment());
    }
}