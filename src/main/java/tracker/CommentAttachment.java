package tracker;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if(o == null || this.getClass() != o.getClass()) return false;
        if(this == o) return true;
        CommentAttachment commentAttachment = (CommentAttachment) o;
        return this.comment.equals(commentAttachment.getComment());
    }

    @Override
    public int hashCode() {
        return (getComment() == null) ? 0 : Objects.hash(getComment());
    }
}
