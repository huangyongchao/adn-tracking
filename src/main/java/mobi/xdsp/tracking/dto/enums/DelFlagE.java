package mobi.xdsp.tracking.dto.enums;

/**
 * 数据删除状态的枚举类
 *
 * @author huangyongchao
 */
public enum DelFlagE {
    YES("yes", 1), NO("no", 0);
    public String name;
    public int code;

    private DelFlagE(String name, int code) {
        this.name = name;
        this.code = code;
    }
}
