package mobi.xdsp.tracking.dto.enums;

/**
 * dsp 规则引擎的规则条件类型
 * @author huangyongchao
 * 1 impressions
 * 2 clicks
 * 3 conversions
 * 4 ctr
 * 5 cost
 */
public enum RulesConditionTypeE {

    IMPRESSIONS("impressions", 1),  CLICKS("clicks", 2),  CONVERSIONS("conversions", 3),  CTR("ctr", 4),  COST("cost", 5);
    public String name;
    public int code;

    private RulesConditionTypeE(String name, int code) {
        this.name = name;
        this.code = code;
    }


}
