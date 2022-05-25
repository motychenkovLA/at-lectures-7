package tracker;

import java.util.Objects;

public class DefectAttachment extends Attachment {
    private final long linkId;

    public DefectAttachment(long linkId) {

        this.linkId = linkId;
    }

    @Override
    public String toString() {
        return "Ссылка на дефект по id: " + linkId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefectAttachment that = (DefectAttachment) o;
        return linkId == that.linkId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(linkId);
    }
}
