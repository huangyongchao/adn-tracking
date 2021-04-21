package mobi.xdsp.tracking.dto;

/**
 * @author huangyongchao
 */
public enum OsE {
    /**
     *
     */
    IOS("ios", "1"), AOS("android", "2");

    public String name;

    public String v;

    private OsE(String name, String v) {
        this.name = name;
        this.v = v;
    }

}
