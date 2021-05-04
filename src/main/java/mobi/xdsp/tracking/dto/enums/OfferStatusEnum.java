package mobi.xdsp.tracking.dto.enums;

/**
 * OFFER 状态枚举值
 */
public enum OfferStatusEnum {
    /*1 有效  2  无效  3 系统暂停 4 冻结(从商家爬回来的offer默认是冻结)*/
    VALID("valid", 1), INVALID("invalid", 2), PAUSE("pause", 3), FROZEN("frozen", 4);


    private String name;
    private int code;

    private OfferStatusEnum(String name, int code) {
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
