package mobi.xdsp.tracking.dto.enums;

public enum OfferApplyTypeEnum {
    /*1 自动审核  2 人工任何*/
    NEEDLESS("needless", 1), NEED("need", 2);

    private String name;
    private int code;

    private OfferApplyTypeEnum(String name, int code) {
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
