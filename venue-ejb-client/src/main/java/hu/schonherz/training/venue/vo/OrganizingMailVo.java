package hu.schonherz.training.venue.vo;

public class OrganizingMailVo implements Sendable {

    private String toEmailAddress;
    private String receiverName;
    private String bandProfileLink;
    private String acceptationLink;
    private String rejectionLink;

    public String getToEmailAddress() {
        return toEmailAddress;
    }

    public void setToEmailAddress(String toEmailAddress) {
        this.toEmailAddress = toEmailAddress;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getBandProfileLink() {
        return bandProfileLink;
    }

    public void setBandProfileLink(String bandProfileLink) {
        this.bandProfileLink = bandProfileLink;
    }

    public String getAcceptationLink() {
        return acceptationLink;
    }

    public void setAcceptationLink(String acceptationLink) {
        this.acceptationLink = acceptationLink;
    }

    public String getRejectionLink() {
        return rejectionLink;
    }

    public void setRejectionLink(String rejectionLink) {
        this.rejectionLink = rejectionLink;
    }
}
