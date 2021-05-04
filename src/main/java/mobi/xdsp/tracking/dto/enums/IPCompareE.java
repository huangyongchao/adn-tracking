package mobi.xdsp.tracking.dto.enums;

/**
 * clickip  bidip  impip 一致性判断的枚举
 *
 * @author huangyongchao
 */
public enum IPCompareE {
    /**
     * NONE   不判断
     * STRICTSAME 严格一致
     * DIFF 不同
     */
    NONE("none", 0), STRICTSAME("strictsame", 1), DIFF("different", 2);
    public String name;
    public int code;

    private IPCompareE(String name, int code) {
        this.name = name;
        this.code = code;
    }
}
