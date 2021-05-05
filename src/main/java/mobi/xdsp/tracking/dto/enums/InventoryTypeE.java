package mobi.xdsp.tracking.dto.enums;


import org.apache.commons.lang3.StringUtils;

/**
 * @author huangyongchao
 */
public enum InventoryTypeE {
    /**
     *
     */
    APP("app", "1"), WEB("web", "2"), Other("other", "-1");

    public String key;

    public String v;

    private InventoryTypeE(String key, String v) {
        this.key = key;
        this.v = v;
    }
    public static String getOtherV(String v) {
        if(StringUtils.isEmpty(v)){
            return Other.v;
        }
        return v;
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

}
