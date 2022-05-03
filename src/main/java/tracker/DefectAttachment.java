package tracker;

public class DefectAttachment extends Attachment {
    public long attachDefectID;

    public DefectAttachment(long defectID, long attachDefectID) {
        super(defectID);
        this.attachDefectID = attachDefectID;
    }

    @Override
    public String asString() {

        return Long.toString(this.attachDefectID);

    }
}
