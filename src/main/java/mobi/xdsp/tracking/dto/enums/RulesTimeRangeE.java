package mobi.xdsp.tracking.dto.enums;

/**
 * dsp 规则引擎的数据统计频率
 * @author huangyongchao
 * 1 Hour
 * 2 24HOUR
 * 3 LAST 3 DAYS
 * 4 LAST 7 DAYS
 */
public enum RulesTimeRangeE {

    HOUR("hour", 1),  HOUR24("hour24", 2),  DAYS3("days3", 3),  DAYS7("days7", 4);
    public String name;
    public int code;

    private RulesTimeRangeE(String name, int code) {
        this.name = name;
        this.code = code;
    }


}
