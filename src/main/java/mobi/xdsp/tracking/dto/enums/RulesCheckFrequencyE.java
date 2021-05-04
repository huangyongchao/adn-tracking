package mobi.xdsp.tracking.dto.enums;

/**
 * dsp 规则引擎的数据统计频率
 * @author huangyongchao
 * 1 Hour
 * 2 Daily
 * 3 Every 3 Days
 * 4 Every Weekly
 */
public enum RulesCheckFrequencyE {

    HOUR("hour", 1),  DAILY("daily", 2),  DAYS3("days3", 3),  WEEKLY("weekly", 4);
    public String name;
    public int code;

    private RulesCheckFrequencyE(String name, int code) {
        this.name = name;
        this.code = code;
    }


}
