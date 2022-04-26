package mobi.xdsp.tracking.dto.enums;


public enum RiskLevelE {

    DEFAULT(0), CRLOW(1), CRHIGH(2);
    public int code;

    private RiskLevelE(int code) {
        this.code = code;
    }
}
