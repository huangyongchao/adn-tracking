package mobi.xdsp.tracking.dto.enums;

/**
 * dsp 报表分组的枚举
 * key 为 dto 以及 数据库的列名
 *
 * @author huangyongchao
 */
public enum ReportGroupE {

    /**
     *
     */
    APPBUNDLE("appbundle", 1),
    /**
     *
     */
    PUBLISHER("pubid", 2),

    /**
     *
     */
    GEO("geo", 3),
    /**
     *
     */
    CRID("crid", 4),
    /**
     *
     */
    CHANNEL("channel", 5),
    /**
     *
     */
    OS("os", 6),
    /**
     *
     */
    CSIZE("csize", 7),
    CTYPE("ctype", 14),
    CARRIER("carrier", 8),
    IP("ip", 9),
    HOUR("bidstmp", 10),
    DAYS("bidstmp", 11),
    MONTH("bidstmp", 12),
    DEVID("devid", 13),
    CID("cid", 16),
    IMPIP("impip", 17),
    DEVMODEL("devmodel", 19),
    CLICKIP("clickip", 18),
    DEVICETYPE("devicetype", 20),
    CONNECTTYPE("connecttype", 21),
    AID("aid", 15);


    public String key;

    public Integer v;

    private ReportGroupE(String key, Integer v) {
        this.key = key;
        this.v = v;
    }

    public static boolean existKey(String key) {
        boolean r = false;
        for (ReportGroupE cfgKeyE : ReportGroupE.values()) {
            if (cfgKeyE.key.equals(key)) {
                r = true;
            }
        }
        return r;
    }

    public static String getKeyByV(Integer v) {

        for (ReportGroupE cfgKeyE : ReportGroupE.values()) {
            if (cfgKeyE.v.equals(v)) {
                return cfgKeyE.key;
            }
        }
        return null;
    }

    public static Integer getVByKey(String v) {
        for (ReportGroupE cfgKeyE : ReportGroupE.values()) {
            if (cfgKeyE.key.equals(v)) {
                return cfgKeyE.v;
            }
        }
        return null;
    }

}
