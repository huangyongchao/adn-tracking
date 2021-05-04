package mobi.xdsp.tracking.dto.enums;

/**
 * @author huangyongchao
 */
public enum IndexModeE {
    /**
     *
     */
    RAM("ram", 1), MMP("mmp", 2);

    public String key;

    public Integer v;

    private IndexModeE(String key, Integer v) {
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

}
