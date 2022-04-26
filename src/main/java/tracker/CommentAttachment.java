package tracker;

public class CommentAttachment extends Attachment{
    private String comment; // todo 1 - можно зафиналить

    public CommentAttachment(String comment) {
        this.comment = comment;
    }

    // todo 1 - лучше текст сделать вроде "коммент: ...", чтобы в консоли было сразу видно какого типа вложения
    @Override
    public String asString() {
        return comment;
    }
}
