package mobi.xdsp.tracking.dto.enums;

/**
 * @author huangyongchao
 */
public enum PBNoticeStateE {
    /**
     *
     */
    NO(0), SENT(1), STOP(2), CTITSTOP(3);
    public int code;

    private PBNoticeStateE(int code) {
        this.code = code;
    }
}
