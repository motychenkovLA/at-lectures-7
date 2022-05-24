package tracker;

import java.util.Objects;

public class Attachment {

    public Defect defect;

    @Override
    public String toString() {
        return "undefined";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Attachment)) return false;
        Attachment that = (Attachment) obj;
        return Objects.equals(defect, that.defect);
    }

    @Override
    public int hashCode() {
        return Objects.hash(defect);
    }
}
