package mobi.xdsp.tracking.dto.enums;

public enum OfferApplyStatusEnum {
    /*1 申请中  2  已批准  3 拒绝  4  暂停*/
    PENDING("pending", 1), APPROVED("approved", 2),
    DECLINED("declined", 3),
    PAUSED("paused", 4),
    CAPFULL("capfull", 5),
    CLICKFULL("clickfull", 6);

    private String name;
    private int code;

    private OfferApplyStatusEnum(String name, int code) {
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
