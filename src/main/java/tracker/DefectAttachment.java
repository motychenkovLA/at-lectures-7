package tracker;

import java.util.Objects;

public class DefectAttachment extends Attachment {
    private final long link;

    public DefectAttachment(long link) {
        this.link = link;
    }

   @Override
    public String toString(){
        return "Ссылка на дефект - " + link;
   }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DefectAttachment defectAttachment = (DefectAttachment) o;
        if (this.hashCode() != defectAttachment.hashCode()) return false;
        return this.link == defectAttachment.link;
    }

    @Override
    public int hashCode() {
        return Objects.hash(link);
    }
}
