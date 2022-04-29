package tracker;

public class DefectAttachment extends Attachment {
    private final long link;

    public DefectAttachment(long link) {
        this.link = link;
    }

   @Override
    public String toString(){
        return "Ссылка на дефект - " + link;
   }
}
