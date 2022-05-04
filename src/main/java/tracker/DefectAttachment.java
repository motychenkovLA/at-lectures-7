package tracker;

public class DefectAttachment extends Attachment {
    public long attachDefectID;

    public DefectAttachment(long attachDefectID) {
        this.attachDefectID = attachDefectID;
    }

    @Override
    public String asString() {

        return Long.toString(this.attachDefectID);

    }
}
