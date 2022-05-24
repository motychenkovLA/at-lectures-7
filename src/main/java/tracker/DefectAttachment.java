package tracker;

import java.util.Objects;

public class DefectAttachment extends Attachment {
    private int linkId; // todo 3 - можно зафиналить

    public DefectAttachment(int linkId) {
        this.linkId = linkId;
    }

    public int getId() {
        return linkId;
    }

    @Override
    public String toString() {
        return "Ссылка на дефект по id: " + linkId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if(this.hashCode() != o.hashCode()) return false; // todo 1 - лишняя проверка
        DefectAttachment defectAttachment = (DefectAttachment) o;
        return linkId == defectAttachment.linkId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}