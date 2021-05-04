package mobi.xdsp.tracking.dto.enums;

/**
 * dsp 活动列表配置的 类型
 *
 * @author huangyongchao
 */
public enum CfgTypeE {
    /**
     * 每一个cfg key 对应的 值类型只能是下面的一种
     * 例如 配置值列表的KEY 是 INVERTORY_PUBLISHER  type 是 INCLUDE
     * 描述的就是 这个活动配置了一个 publisher条件 条件类型是包含 某些值
     */
    INCLUDE("include", 1), EXCLUDE("exclude", 2), NONE("none", 3);
    public String name;
    public int code;

    private CfgTypeE(String name, int code) {
        this.name = name;
        this.code = code;
    }


}
