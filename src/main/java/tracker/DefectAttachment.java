package tracker;

public class DefectAttachment extends Attachment {
    public long attachDefectID;

    public DefectAttachment(long attachDefectID) {
        this.attachDefectID = attachDefectID;
    }

    @Override
    public String toString() {

        return "Связанный дефект: " + Long.toString(this.attachDefectID);

    }
}
