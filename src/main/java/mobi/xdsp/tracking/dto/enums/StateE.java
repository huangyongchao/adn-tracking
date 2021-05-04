package mobi.xdsp.tracking.dto.enums;

/**
 * 数据有效状态的枚举类
 * 不要轻易改 因为很多逻辑条件要和数据库表一起操作
 * name 是offer里的状态
 * key 是dsp里的数据状态
 *
 * @author huangyongchao
 */
public enum StateE {
    /**
     * active 有效
     * expiry 无效
     * ext1-3  不同业务可以替代不同状态,业务内部识别就好
     */
    VALID("active", 0), INVALID("expiry", 1), EXT1("ext1", 2), EXT2("ext1", 3), EXT3("ext1", 4);
    public String name;
    public int code;

    private StateE(String name, int code) {
        this.name = name;
        this.code = code;
    }
}
