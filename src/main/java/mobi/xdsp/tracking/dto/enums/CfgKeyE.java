package mobi.xdsp.tracking.dto.enums;

/**
 * dsp 活动列表配置的 KEY
 *
 * @author huangyongchao
 */
public enum CfgKeyE {
    /**
     *
     */
    INVENTORY_PUBLISHERS("INVENTORY_PUBLISHERS", 1),
    /**
     *
     */
    INVENTORY_APPSITE("INVENTORY_APPSITE", 2),
    /**
     *
     */
    INVENTORY_APPBUNDLES("INVENTORY_APPBUNDLES", 3),
    /**
     *
     */
    INVENTORY_APPIABCATEGORY("INVENTORY_APPIABCATEGORY", 4),
    /**
     *
     */
    INVENTORY_APPSTORECATEGORY("INVENTORY_APPSTORECATEGORY", 5),
    /**
     *
     */
    INVENTORY_DOMAINLIST("INVENTORY_DOMAINLIST", 6),
    /**
     *
     */
    TARGETING_COUNTRIES("TARGETING_COUNTRIES", 7),
    /**
     *
     */
    TARGETING_CITIES("TARGETING_CITIES", 8),
    /**
     *
     */
    TARGETING_IPRANGES("TARGETING_IPRANGES", 9),
    /**
     *
     */
    TARGETING_CARRIERS("TARGETING_CARRIERS", 10),
    /**
     *
     */
    TARGETING_DEVICEID("TARGETING_DEVICEID", 11),
    /**
     *
     */
    TARGETING_DEVICEMODEL("TARGETING_DEVICEMODEL", 32),
    /**
     *
     */


    TARGETING_SCHEDULE("TARGETING_SCHEDULE", 33),
    /**
     *
     */
    TARGETING_IOSVERSION("TARGETING_IOSVERSION", 44),
    /**
     *
     */
    TARGETING_ANDROIDVERSION("TARGETING_ANDROIDVERSION", 55),
    /**
     * @see CfgTypeE None
     */
    CREATIVES("CREATIVES", 66),
    /**
     * @see CfgTypeE None
     */
    MICROBIDDING("MICROBIDDING", 77),
    /**
     * @see CfgTypeE None
     */
    RULES("RULES", 18),

    /**
     * PMP 模式下DEAL  ID
     */
    DEAL("DEAL", 19);

    public String key;

    public Integer v;

    private CfgKeyE(String key, Integer v) {
        this.key = key;
        this.v = v;
    }

    public static boolean existKey(String key) {
        boolean r = false;
        for (CfgKeyE cfgKeyE : CfgKeyE.values()) {
            if (cfgKeyE.key.equals(key)) {
                r = true;
            }
        }
        return r;
    }

    public static String getKeyByV(Integer v) {
        for (CfgKeyE cfgKeyE : CfgKeyE.values()) {
            if (cfgKeyE.v.equals(v)) {
                return cfgKeyE.key;
            }
        }
        return null;
    }

    public static Integer getVByKey(String v) {
        for (CfgKeyE cfgKeyE : CfgKeyE.values()) {
            if (cfgKeyE.key.equals(v)) {
                return cfgKeyE.v;
            }
        }
        return null;
    }

}
