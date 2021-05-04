package mobi.xdsp.tracking.dto.enums;

/**
 * dsp 规则引擎的规则应用类型
 * @author huangyongchao
 * 1 百分比 增加或者减少
 * 2 特定金额 增加或者减少
 */
public enum MicroBidUnitE {

    PERCENT("percent", 1),  FIXED("fixed", 2);
    public String name;
    public int code;

    private MicroBidUnitE(String name, int code) {
        this.name = name;
        this.code = code;
    }


}
