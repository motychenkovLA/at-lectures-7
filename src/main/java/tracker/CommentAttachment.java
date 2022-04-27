package tracker;

public class CommentAttachment extends Attachment {
    private final String comment;

    public CommentAttachment(String comment) {
        this.comment = comment;
    }

    public String asString() {
        // todo 1 - запятая тут не при чем,
        //  у атача должно быть нормальное отображение в отрыве от всего остального
        //  сейчас если вызвать то получится " , Коммент: ..." что выглядит немного странно
        //  + аналогично для DefectAttachment
        return "Комментарий: " + comment;
    }
}
