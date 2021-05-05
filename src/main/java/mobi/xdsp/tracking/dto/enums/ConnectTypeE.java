package mobi.xdsp.tracking.dto.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * @author huangyongchao
 */
public enum ConnectTypeE {
    /**
     *
     */
    WIFI("wifi", "2"), G4("g", "6"), G3("g", "5"), Other("other", "0");

    public String key;

    public String v;

    private ConnectTypeE(String key, String v) {
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
    public static String getOtherV(String v) {
        if(StringUtils.isEmpty(v)){
            return Other.v;
        }
        return v;
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
