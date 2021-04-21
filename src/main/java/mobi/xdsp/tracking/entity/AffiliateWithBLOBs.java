package mobi.xdsp.tracking.entity;

public class AffiliateWithBLOBs extends Affiliate {
    private byte[] subidconf;

    private byte[] adjustconf;

    private byte[] openconf;

    public byte[] getSubidconf() {
        return subidconf;
    }

    public void setSubidconf(byte[] subidconf) {
        this.subidconf = subidconf;
    }

    public byte[] getAdjustconf() {
        return adjustconf;
    }

    public void setAdjustconf(byte[] adjustconf) {
        this.adjustconf = adjustconf;
    }

    public byte[] getOpenconf() {
        return openconf;
    }

    public void setOpenconf(byte[] openconf) {
        this.openconf = openconf;
    }
}