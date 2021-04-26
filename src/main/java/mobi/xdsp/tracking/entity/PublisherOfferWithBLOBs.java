package mobi.xdsp.tracking.entity;

public class PublisherOfferWithBLOBs extends PublisherOffer {
    private String whitelist;

    private String blacklist;

    public String getWhitelist() {
        return whitelist;
    }

    public void setWhitelist(String whitelist) {
        this.whitelist = whitelist == null ? null : whitelist.trim();
    }

    public String getBlacklist() {
        return blacklist;
    }

    public void setBlacklist(String blacklist) {
        this.blacklist = blacklist == null ? null : blacklist.trim();
    }
}