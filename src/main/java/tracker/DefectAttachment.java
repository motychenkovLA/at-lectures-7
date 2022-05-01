package tracker;

public class DefectAttachment extends Attachment {

    public int link;

    public DefectAttachment(int link) {
        this.link = link;
    }

    @Override
    public String asString() {
        return "—сылка на дефект: " + this.link;
    }

}
