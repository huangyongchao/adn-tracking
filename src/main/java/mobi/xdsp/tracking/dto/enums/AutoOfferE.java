package mobi.xdsp.tracking.dto.enums;

/**
 * @author huangyongchao
 */
public enum AutoOfferE {
    /**
     *
     */
    RUN("AutoRun", "1"), ADJUST("AutoAdjust", "2"), CLOSE("AutoClose", "3"), SUBID("AutoSubid", "4");

    public String key;

    public String v;

    private AutoOfferE(String key, String v) {
        this.key = key;
        this.v = v;
    }


    public static boolean existKey(String key) {
        boolean r = false;
        for (AutoOfferE cfgKeyE : AutoOfferE.values()) {
            if (cfgKeyE.key.equals(key)) {
                r = true;
            }
        }
        return r;
    }


    public static String getKeyByV(Integer v) {
        for (AutoOfferE cfgKeyE : AutoOfferE.values()) {
            if (cfgKeyE.v.equals(v)) {
                return cfgKeyE.key;
            }
        }
        return null;
    }

}
