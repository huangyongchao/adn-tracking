package mobi.xdsp.tracking.dto;

/**
 * @author huangyongchao
 * 自动运营开关
 */
public enum SubidTypeE {
    /**
     * AUTO 自动默认
     * MANUAL 手动
     * AUTO_ALL 每天自动更换
     * AUTO_P360 每6小时更换
     */
    AUTO(0), MANUAL(-1), AUTO_ALL(1), AUTO_P360(2);
    public int code;

    private SubidTypeE(int code) {
        this.code = code;
    }
}
