package mobi.xdsp.tracking.dto.enums;

import org.apache.commons.lang.StringUtils;

/**
 * @author huangyongchao
 */
public enum OsE {
    /**
     *
     */
    iOS("ios", "1"), Android("android", "2"), Other("other", "3");

    public String key;

    public String v;

    private OsE(String key, String v) {
        this.key = key;
        this.v = v;
    }


    public static boolean existKey(String key) {
        boolean r = false;
        for (OsE cfgKeyE : OsE.values()) {
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
        for (OsE cfgKeyE : OsE.values()) {
            if (cfgKeyE.v.equals(v)) {
                return cfgKeyE.key;
            }
        }
        return null;
    }

}
