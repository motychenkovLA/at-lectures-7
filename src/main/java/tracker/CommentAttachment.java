package tracker;

import java.util.Objects;

public class CommentAttachment extends Attachment {
    public String comment;

    public CommentAttachment(String comment) throws MyExeption {
        if (comment.length()!=0)
        this.comment = comment;
        else throw new MyExeption();
    }

    @Override
    public String toString() {

        return "Комментарий: " + this.comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommentAttachment)) return false;
        CommentAttachment commAtt = (CommentAttachment) o;
        return this.comment.equals(commAtt.comment);
    }

    @Override
    public int hashCode() {
        return this.comment.hashCode();
    }
}
