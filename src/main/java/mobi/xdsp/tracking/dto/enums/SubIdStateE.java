package mobi.xdsp.tracking.dto.enums;

/**
 * @author huangyongchao
 */
public enum SubIdStateE {
    /**
     * black 无业绩拉黑
     * autonew 新增
     * schedule 计划补充
     */
    BLACK("black", 0), AUTONEW("autonew", 1), SCHEDULE("schedule", 2), EXT2("ext1", 3), EXT3("ext1", 4);
    public String name;
    public int code;

    private SubIdStateE(String name, int code) {
        this.name = name;
        this.code = code;
    }
}
