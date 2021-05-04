package mobi.xdsp.tracking.dto.enums;

/**
 * dsp 规则引擎的规则条件操作类型
 * @author huangyongchao
 * 1 >
 * 2 <
 */
public enum RulesOpTypeE {

    MORETHAN("morethan", 1),  LESSTHAN("lessthan", 2);
    public String name;
    public int code;

    private RulesOpTypeE(String name, int code) {
        this.name = name;
        this.code = code;
    }


}
