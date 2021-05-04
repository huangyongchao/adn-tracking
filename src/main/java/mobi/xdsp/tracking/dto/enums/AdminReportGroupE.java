package mobi.xdsp.tracking.dto.enums;

/**
 * admin 报表分组的枚举
 * key 为 dto 以及 数据库的列名
 *
 * @author huangyongchao
 */
public enum AdminReportGroupE {

    /**
     *
     */
    OFFER("offeruid", 1),
    /**
     *
     */
    APP("appid", 2),

    /**
     *
     */
    AFF("affiliateid", 3),
    /**
     *
     */
    AID("aid", 4),

    APPGEO("appgeo", 5),
    GEO("country", 6),
    /**
     *
     */
    ACTIME("activatetime", 9),
    REVENUE("defaultpayout", 10),
    /**
     *
     */
    CONVS("convs", 11);


    public String key;

    public Integer v;

    private AdminReportGroupE(String key, Integer v) {
        this.key = key;
        this.v = v;
    }

    public static boolean existKey(String key) {
        boolean r = false;
        for (AdminReportGroupE cfgKeyE : AdminReportGroupE.values()) {
            if (cfgKeyE.key.equals(key)) {
                r = true;
            }
        }
        return r;
    }

    public static String getKeyByV(Integer v) {

        for (AdminReportGroupE cfgKeyE : AdminReportGroupE.values()) {
            if (cfgKeyE.v.equals(v)) {
                return cfgKeyE.key;
            }
        }
        return null;
    }

    public static Integer getVByKey(String v) {
        for (AdminReportGroupE cfgKeyE : AdminReportGroupE.values()) {
            if (cfgKeyE.key.equals(v)) {
                return cfgKeyE.v;
            }
        }
        return null;
    }

}
