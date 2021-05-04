package mobi.xdsp.tracking.dto.enums;

/**
 * @author huangyongchao
 */
public enum BidTrackTypeE {
    /**
     * bid 请求的每个环节 都用一个类型标记 节省存储空间
     * <p>
     * bid  win  imp  click  convert
     */
    BID("BID", 1),
    WIN("WIN", 2),
    IMP("IMP", 3),
    CLICK("CLICK", 4),
    LAND("LAND", 6),
    CONV("CONV", 5);

    public String key;

    public int v;

    private BidTrackTypeE(String key, int v) {
        this.key = key;
        this.v = v;
    }

}
