package mobi.xdsp.tracking.dto.enums;

/**
 * OFFER 申请类型的枚举
 */
public enum OfferApplyEnum {
    /*1 不需要申请  2  需要申请*/
    NEEDLESS("needless", 1), NEED("need", 2);

    private String name;
    private int code;

    private OfferApplyEnum(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
