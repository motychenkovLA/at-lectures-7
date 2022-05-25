package tracker;

import java.util.Objects;

public class DefectAttachment extends Attachment {
    public long attachDefectID;

    public DefectAttachment(long attachDefectID) {
        this.attachDefectID = attachDefectID;
    }

    @Override
    public String toString() {

        return "Связанный дефект: " + this.attachDefectID;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefectAttachment defAtt = (DefectAttachment) o;
        return attachDefectID == defAtt.attachDefectID;
    }

    @Override
    public int hashCode() {
        return (int) attachDefectID;
    }
}
