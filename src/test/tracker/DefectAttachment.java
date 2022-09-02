package tracker;

import java.util.Objects;

public class DefectAttachment extends Attachment {

    private final Long id;

    public DefectAttachment(Long id) {

        this.id = id;
    }

    public long getId(){
        return id;
    }

    @Override
    public String toString() {

        return id.toString();
    }

    @Override
    public boolean equals (Object o) {
        if (this==o) return  true;
        if (o==null || getClass() != o.getClass()) return  false;
        DefectAttachment defectAttachment = (DefectAttachment) o;
        return this.id.equals(defectAttachment.getId());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId());
    }
}
