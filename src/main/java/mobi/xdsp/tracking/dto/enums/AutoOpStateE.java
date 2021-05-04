package mobi.xdsp.tracking.dto.enums;

/**
 * @author huangyongchao
 * 自动运营开关
 */
public enum AutoOpStateE {
    /**
     * AUTO 有效
     * MANUAL 手动
     * AUTO_ALL 每天自动更换
     */
    AUTO(0), MANUAL(-1), AUTO_ALL(1), AUTO_P360(2);
    public int code;

    private AutoOpStateE(int code) {
        this.code = code;
    }
}
