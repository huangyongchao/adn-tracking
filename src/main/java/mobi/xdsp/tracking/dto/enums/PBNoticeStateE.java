package mobi.xdsp.tracking.dto.enums;

/**
 * @author huangyongchao
 */
public enum PBNoticeStateE {
    /**
     *
     */
    NO(new Byte("0")), SENT(new Byte("1")), STOP(new Byte("2")), CTITSTOP(new Byte("3")) ,CAPSTOP(new Byte("4"));
    public Byte code;

    private PBNoticeStateE(Byte code) {
        this.code = code;
    }
}
