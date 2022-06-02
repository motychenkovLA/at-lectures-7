package tracker;

import java.util.Objects;

public class DefectAttachment extends Attachment {

    private int idDefect;

    public DefectAttachment(int idDefect) {
        this.idDefect = idDefect;
    }

    public String toString() {
        return String.valueOf(idDefect);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefectAttachment that = (DefectAttachment) o;
        if (this.hashCode() != o.hashCode()) return false;
        return idDefect == that.idDefect;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDefect);
    }
}
