package mobi.xdsp.tracking.dto.enums;

/**
 * OFFER 状态枚举值
 */
public enum BlackListStatusEnum {
    /*1 有效  2  无效*/
    VALID("valid", 1), INVALID("invalid", 2);


    private String name;
    private int code;

    private BlackListStatusEnum(String name, int code) {
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
