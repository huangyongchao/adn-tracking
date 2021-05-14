package mobi.xdsp.tracking.dto.enums;

/**
 * @author huangyongchao
 */
public enum PBStateE {
    /**
     * ext1-3  不同业务可以替代不同状态,业务内部识别就好
     */
    VALID("active", new Byte("1")), INVALID("expiry", new Byte("0"));
    public String name;
    public byte code;

    private PBStateE(String name, byte code) {
        this.name = name;
        this.code = code;
    }
}
