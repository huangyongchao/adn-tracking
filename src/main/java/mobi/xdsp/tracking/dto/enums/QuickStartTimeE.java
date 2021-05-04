package mobi.xdsp.tracking.dto.enums;

/**
 * dsp quick query time KEY
 *
 * @author huangyongchao
 */
public enum QuickStartTimeE {

    /**
     *
     */
    Today("Today", 1),
    /**
     *
     */
    Yesterday("Yesterday", 2),
    /**
     *
     */
    Last2Days("Last2Days", 10),
    /**
     *
     */
    Last3Days("Last3Days", 3),
    /**
     *
     */
    Last7Days("Last7Days", 4),
    /**
     *
     */
    Month("Month", 5),
    /**
     *
     */
    LastMonth("LastMonth", 6),
    /**
     *
     */
    Year("Year", 7),
    All("All", 20),
    Last30Days("Last30Days", 9),

    Last14Days("Last14Days", 8);


    public String key;

    public Integer v;

    private QuickStartTimeE(String key, Integer v) {
        this.key = key;
        this.v = v;
    }

    public static boolean existKey(String key) {
        boolean r = false;
        for (QuickStartTimeE cfgKeyE : QuickStartTimeE.values()) {
            if (cfgKeyE.key.equals(key)) {
                r = true;
            }
        }
        return r;
    }

    public static String getKeyByV(Integer v) {
        for (QuickStartTimeE cfgKeyE : QuickStartTimeE.values()) {
            if (cfgKeyE.v.equals(v)) {
                return cfgKeyE.key;
            }
        }
        return null;
    }

    public static Integer getVByKey(String v) {
        for (QuickStartTimeE cfgKeyE : QuickStartTimeE.values()) {
            if (cfgKeyE.key.equals(v)) {
                return cfgKeyE.v;
            }
        }
        return null;
    }

}
