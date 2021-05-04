package mobi.xdsp.tracking.dto.enums;

/**
 * dsp 活动列表配置的素材类型
 *
 * @author huangyongchao
 * <p>
 * code 一定要保证是 1位 后面要截取,暂时只只支持1位
 */
public enum CreativeTypeE {

    BANNER("banner", 1), VIDEO("video", 2), HTML("html", 3), NATIVE("native", 4), REWARDEDVIDEO("rewardedvideo", 5);
    public String name;
    public int code;

    private CreativeTypeE(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public static String getKeyByV(Integer code) {
        for (CreativeTypeE e : CreativeTypeE.values()) {
            if (e.code == code) {
                return e.name;
            }
        }
        return null;
    }

    public static Integer getVByKey(String name) {
        for (CreativeTypeE e : CreativeTypeE.values()) {
            if (e.name.equals(name)) {
                return e.code;
            }
        }
        return null;
    }

}
