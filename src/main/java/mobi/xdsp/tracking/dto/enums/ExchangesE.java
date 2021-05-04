package mobi.xdsp.tracking.dto.enums;

/**
 * @author huangyongchao
 */
public enum ExchangesE {
    /**
     *
     */
    SMAATO("smaato",1),MOBFOX("mobfox",2), ADCOLONY("adcolony",3);

    public String key;
    public Integer code;
    private ExchangesE(String key,Integer code) {
        this.key = key;
        this.code = code;
    }

    public static Integer getCode(String key) {
        for (ExchangesE exchangesE : ExchangesE.values()) {
            if (exchangesE.key.equals(key)) {
                return exchangesE.code;
            }
        }
        return null;
    }



    public static boolean existKey(String key) {
        boolean r = false;
        for (ExchangesE cfgKeyE : ExchangesE.values()) {
            if (cfgKeyE.key.equals(key)) {
                r = true;
            }
        }
        return r;
    }

}
